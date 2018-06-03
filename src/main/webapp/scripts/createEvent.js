$(document).ready(function() {

    $('.eventForm').submit(function(event){
        event.preventDefault();

        var eventConfString = eventConfirmationStringBuilder($('.eventForm'));
        if (confirm("Before submitting, is all of the event information correct? \nTo make changes, press cancel.\n" + eventConfString )) {
            var $formInfo = $('.eventForm').serialize();
            console.log($formInfo);

            $.ajax({
                url:"/createEvent",
                data: $formInfo,
                type: 'POST',
                success:function(data) {
                    alert("Post Successful!");
                    $('.eventForm').trigger("reset");
                },
                error:function(data, status, err) {
                    alert("Post failed! Error msg: " + data.responseText);
                }
            })
        }

    });

    var eventConfirmationStringBuilder = function(formInfo) {
        var formArray = formInfo.serializeArray();
        var confirmationString = "";
        for(var i = 0; i < formArray.length; i++) {
           confirmationString = confirmationString +  formArray[i].name + ": " + formArray[i].value + "\n";
        }
        return confirmationString;
    };
    
});