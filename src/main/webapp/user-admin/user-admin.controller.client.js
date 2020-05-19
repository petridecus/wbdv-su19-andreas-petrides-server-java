(function () {
  let users = []
  let $listContent, $addBtn, $updateBtn
  let $usernameFld, $passwordFld, $firstFld, $lastFld, $roleFld
  let service = new AdminUserServiceClient()
  let selectedUser = {}

  function deleteUser(event) {
    console.log(event)
    const target = event.currentTarget
    const $button = $(target)
    const userId = $button.attr('id')
    service.deleteUser(userId)
      .then(function() {
        users = users.filter(function(user) {
          return user._id !== userId
        })
        renderAllUsers()
      })
  }

  function renderUser(user) {
    selectedUser = user
    $usernameFld.val(user.username)
    $passwordFld.val(user.password)
    $firstFld.val(user.first)
    $lastFld.val(user.last)
    $roleFld.val(user.role)
  }
  
  function updateUser() {
    const updatedUser = {
      _id: selectedUser._id,
      username: $usernameFld.val(),
      password: $passwordFld.val(),
      first: $firstFld.val(),
      last: $lastFld.val(),
      role: $roleFld.val()
    }

    service.updateUser(selectedUser._id, updatedUser)
      .then(function(status) {
        users = users.map(function(user) {
          if(user._id === selectedUser._id) {
            return updatedUser
          } else {
            return user
          }
        })
        renderAllUsers()
        clearFields()
      })
  }

  function selectUser(event) {
    const target = event.currentTarget
    const $button = $(target)
    const userId = $button.attr('id')
    service.findUserById(userId)
      .then(function (user) {
        console.log(user)
        renderUser(user)
      })
  }

  function renderAllUsers() {
    console.log(users)
    const template = $('.wbdv-user-row-template')[0]
    const $template = $(template)
    const clone = $template.clone()
    $listContent.empty()
    for(let i=0; i<users.length; i++) {
      const user = users[i]
      console.log(user)
      const copy = clone.clone()
      copy.find('.wbdv-username').html(user.username)
      copy.find('.wbdv-password').html(user.password)
      copy.find('.wbdv-first-name').html(user.first)
      copy.find('.wbdv-last-name').html(user.last)
      copy.find('.wbdv-role').html(user.role)
      copy.find('.wbdv-delete')
        .attr('id', user._id)
        .click(deleteUser)
      copy.find('.wbdv-edit')
        .attr('id', user._id)
        .click(selectUser)
      $listContent.append(copy)
    }
  }
  
  function createUser() {
    const username = $usernameFld.val()
    const password = $passwordFld.val()
    const first = $firstFld.val()
    const last = $lastFld.val()
    const role = $roleFld.val()

    const newUser = {
      username: username,
      password: password,
      first: first,
      last: last,
      role: role,
    }

    service.createUser(newUser)
      .then(function (actualUser) {
        users.push(actualUser)
        renderAllUsers()
        clearFields()
      })
  }
  
  function findAllUsers() {
    service.findAllUsers()
      .then(function (allUsers) {
        users = allUsers
        renderAllUsers()
      })
  }

  function clearFields() {
    $usernameFld.val('')
    $passwordFld.val('')
    $firstFld.val('')
    $lastFld.val('')
    $roleFld.val('')
  }

  function main() {
    $listContent = $('.list-content')
    $addBtn = $('.wbdv-add-btn')
    $theUpdateBtn = $('.wbdv-update')

    $addBtn.click(createUser)
    $theUpdateBtn.click(updateUser)

    $usernameFld = $('.wbdv-username-fld')
    $passwordFld = $('.wbdv-password-fld')
    $firstFld = $('.wbdv-first-fld')
    $lastFld = $('.wbdv-last-fld')
    $roleFld = $('.wbdv-role-fld')

    findAllUsers()
  }

  jQuery(main)

})()
