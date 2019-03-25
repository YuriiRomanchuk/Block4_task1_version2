<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
<%
    String error = (String) request.getAttribute("Error");
    if (error != null) {
%> <h1><%=error%>
</h1> <%
    }
%>
<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <h1>Add user data</h1>
            <form method="post" action="add-user-data" class="form" role="form">

                <div class="col-auto my-1">
                    <div class="form-group">
                        <label for="lastName">Last name:</label>
                        <input type="lastName" class="form-control" id="lastName" name="lastName"
                               placeholder="Enter last name">
                        <label for="firstName">First name:</label>
                        <input type="firstName" class="form-control" id="firstName" name="firstName"
                               placeholder="Enter first name">
                        <label for="middleName">Middle name:</label>
                        <input type="middleName" class="form-control" id="middleName" name="middleName"
                               placeholder="Enter middle name">
                        <label for="nickname">Nickname:</label>
                        <input type="nickname" class="form-control" id="nickname" name="nickname"
                               placeholder="Enter nickname">
                        <label for="groupName">Group name:</label>
                        <input type="groupName" class="form-control" id="groupName" name="groupName"
                               placeholder="Enter group name">
                        <label for="comment">Comment:</label>
                        <input type="comment" class="form-control" id="comment" name="comment"
                               placeholder="Enter comment">
                        <label for="skype">Skype:</label>
                        <input type="skype" class="form-control" id="skype" name="skype"
                               placeholder="Enter skype">
                        <label for="homePhoneNumber">Home phone number:</label>
                        <input type="number" class="form-control" id="homePhoneNumber" name="homePhoneNumber"
                               placeholder="Enter home phone number">
                        <label for="mobilePhoneNumber">Mobile phone number:</label>
                        <input type="number" class="form-control" id="mobilePhoneNumber" name="mobilePhoneNumber"
                               placeholder="Enter mobile phone number">
                        <label for="mobilePhoneNumberSecond">Second mobile phone number:</label>
                        <input type="email" class="form-control" id="mobilePhoneNumberSecond"
                               name="mobilePhoneNumberSecond"
                               placeholder="Enter second mobile phone number">
                        <label for="city">City:</label>
                        <input type="city" class="form-control" id="city" name="city"
                               placeholder="Enter city">
                        <label for="street">Street:</label>
                        <input type="street" class="form-control" id="street" name="street"
                               placeholder="Enter street">
                        <label for="houseNumber">House number:</label>
                        <input type="houseNumber" class="form-control" id="houseNumber" name="houseNumber"
                               placeholder="Enter house number">
                        <label for="flatNumber">Flat number:</label>
                        <input type="flatNumber" class="form-control" id="flatNumber" name="flatNumber"
                               placeholder="Enter flat number">
                        <label for="index">Index:</label>
                        <input type="number" class="form-control" id="index" name="index"
                               placeholder="Enter index">
                    </div>
                </div>

                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
