(function () {
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;
    var $userList;
    var userService = new AdminUserServiceClient();

    let users = []
    let usernameFld = $("#usernameFld")
    let $userTable = $("#user-table")

    // Retrieve DOM elements, bind action icons to event handlers
    function main() {
        $userList = $("#userList")
        $usernameFld = $("#usernameFld")
        $createBtn = $("#createBtn")
        $createBtn.click(createUser)
        $editBtn = $("#editBtn")
        $editBtn.click(updateUser)

        userService
            .findAllUsers()
            .then(theusers => {
                users = theusers
                renderUsers()
            })
    }

    // Creates a user object and update list of users on server response
    function createUser() {
        const newUser = {
            username: $usernameFld.val()
        }
        $usernameFld.val("")

        userService.createUser(newUser)
            .then((actualUser) => {
                // users.push(actualUser)
                // renderUsers()
                findAllUsers()
            })
    }

    function findAllUsers() {
        userService
            .findAllUsers()
            .then(theusers => {
                users = theusers
                renderUsers()
            })
    }

    function findUserById() { … }

    function deleteUser(index) {
        let user = users[index]
        let userId = user._id

        userService.deleteUser(userId)
            .then(response => {
                users.splice(index, 1)
                renderUsers()
            })
    }

    function selectUser() { … }

    let currentUserIndex = -1
    function editUser(index) {
        currentUserIndex = index
        let user = users[index]
        let userId = user._id

        userService.findUserById(userId)
            .then(actualUser => {
                $usernameFld.val(actualUser.username)
            })
    }

    function updateUser() {
        const updatedUser = {
            username: $usernameFld.val()
        }
        $usernameFld.val("")
        updatedUser._id = users[currentUserIndex]._id

        userService.updateUser(updatedUser._id, updatedUser)
            .then((actualUser) => {
                findAllUsers()
            })
    }

    function renderUser(user) { … }

    function renderUsers(users) {
        $userList.empty()
        for (let u in users) {
            let user = users[u]

            $deleteBtn = $("<button>Delete</button>")
            $deleteBtn.click(() => deleteUser(u))

            $editBtn = $("<button>Edit</button>")
            $editBtn.click(() => editUser(u))

            $li = $("<li>")
            $li.append($deleteBtn)
            $li.append($editBtn)
            $li.append(user.username)
            $userList.append($li)
        }
    }

    $(main)

})()