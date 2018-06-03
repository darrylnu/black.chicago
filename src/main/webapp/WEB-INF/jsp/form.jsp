<!DOCTYPE html>
<html>
<head>
<title>Create Event</title>
</head>
<body>
    <form class="eventForm">
        Event Name:<br>
        <input type="text" name="eventName" required><br><br>
        Venue name:<br>
        <input type="text" name="venueName" required><br><br>
        Street Address:<br>
        <input type="text" name="streetAddress" required><br><br>
        City:<br>
        <input type="text" name="city" value="Chicago"><br><br>
        State:<br>
        <input type="text" name="state" value="IL"><br><br>
        Zipcode:<br>
        <input type="number" name="zipCode" minlength="5" maxlength="5"><br><br>
        Date:<br>
        <input type="date" name="date" required><br><br>
        Start Time:<br>
        <input type="time" name="startTime" required><br><br>
        End Time:<br>
        <input type="time" name="endTime"><br><br>
        Event Image Link:<br>
        <input type="url" name="eventImgUrl" required><br><br>
        Reservation Link:<br>
        <input type="url" name="reservationLink" required><br><br>
        Event Description:<br>
        <input type="text" name="description" maxlength="500"><br><br><br>
    
        <input type="submit" value="Submit">
    
      </form>

      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
      <script src="../scripts/createEvent.js"></script>
</body>
</html>