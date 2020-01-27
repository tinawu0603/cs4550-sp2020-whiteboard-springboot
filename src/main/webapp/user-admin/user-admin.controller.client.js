(function () {
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $updateBtn, $createBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;
    var userService = new AdminUserServiceClient();
    var curUserId;

    let users = []

    // Retrieve DOM elements, bind action icons to event handlers
    function main() {
        $usernameFld = $("#usernameFld")
        $passwordFld = $("#passwordFld")
        $firstNameFld = $("#firstNameFld")
        $lastNameFld = $("#lastNameFld")
        $roleFld = $("#roleFld")
        $createBtn = $("#createBtn")
        $createBtn.click(createUser)
        $removeBtn = $("#removeBtn")
        $removeBtn.click(deleteUser)
        $updateBtn = $("#updateBtn")
        $updateBtn.click(updateUser)
        $editBtn = $("#editBtn")
        $userRowTemplate = $("#userRowTemplate")
        $tbody = $("#tableBody")

        userService
            .findAllUsers()
            .then(theusers => {
                users = theusers
                renderUsers(theusers)
            })
    }

    // Creates a user object and update list of users on server response
    function createUser() {
        const newUser = {
            username: $usernameFld.val(),
            password: $passwordFld.val(),
            firstname: $firstNameFld.val(),
            lastname: $lastNameFld.val(),
            role: $roleFld.val(),
        }
        $usernameFld.val("");
        $passwordFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("");
        $roleFld.val("Faculty");

        userService.createUser(newUser)
            .then((actualUser) => {
                users.push(actualUser)
                findAllUsers()
            })
    }

    // Retrieve all the users and passes response 
    function findAllUsers() {
        userService
            .findAllUsers()
            .then(theusers => {
                users = theusers
                renderUsers(theusers)
            })
    }

    // Retrieve a user by their ID
    function findUserById() {
        userService.findUserById(curUserId)
            .then((actualuser) => {
                renderUser(actualuser)
            })
    }

    // Deletes a user
    function deleteUser(userId) {
        userService.deleteUser(userId)
            .then(response => {
                findAllUsers()
            })
    }

    // Reads new values and creates new user object
    function updateUser() {
        const updatedUser = {
            username: $usernameFld.val(),
            password: $passwordFld.val(),
            firstname: $firstNameFld.val(),
            lastname: $lastNameFld.val(),
            role: $roleFld.val(),
        }
        if (updatedUser.username == "") {
            return;
        }
        $usernameFld.val("");
        $passwordFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("");
        $roleFld.val("Faculty");
        updatedUser._id = curUserId

        userService.updateUser(updatedUser._id, updatedUser)
            .then((actualUser) => {
                findAllUsers()
            })
    }

    // Updates the form with the given user's new properties
    function renderUser(user) {
        $usernameFld.val(user.username)
        $firstNameFld.val(user.firstname)
        $lastNameFld.val(user.lastname)
        $roleFld.val(user.role)
    }

    // Iterates over given users and populates the table
    function renderUsers(users) {
        $tbody.empty();
        $usernameFld.val("");
        $passwordFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("");
        $roleFld.val("Faculty");

        for (let u in users) {
            user = users[u]

            const userClone = $userRowTemplate.clone();
            userClone.removeClass('wbdv-hidden');
            userClone.find('.wbdv-username').html(user.username);
            // userClone.find('.wbdv-password').html(user.password);
            userClone.find('.wbdv-first-name').html(user.firstname);
            userClone.find('.wbdv-last-name').html(user.lastname);
            userClone.find('.wbdv-role').html(user.role);

            let removeButtonId = "removeBtn-".concat(user._id);
            let removeButton1 = "<button id=\"";
            let removeButton2 = removeButton1.concat(removeButtonId);
            let removeButton3 = removeButton2.concat("\" type=\"button\" class=\"btn wbdv-remove\"><img src=\"../css/x-black.svg\"></button>");

            let editButtonId = "editBtn-".concat(user._id);
            let editButton1 = "<button id=\"";
            let editButton2 = editButton1.concat(editButtonId);
            let editButton3 = editButton2.concat("\" type=\"button\" class=\"btn wbdv-edit\"><img src=\"../css/edit.svg\"></button>");

            let userActions = "<span class=\"float-right\">".concat(removeButton3, editButton3, "</span>");
            userClone.find('.wbdv-actions').html(userActions);

            $tbody.append(userClone);
            let newRemoveBtn = $("#removeBtn-".concat(user._id));
            let newEditBtn = $("#editBtn-".concat(user._id));

            newRemoveBtn.click(function () {
                deleteUser($(this).attr('id').slice(10))
            });

            newEditBtn.click(function () {
                curUserId = $(this).attr('id').slice(8)
                findUserById();
            });
        }
    }
    $(main)

})()