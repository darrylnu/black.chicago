$(document).ready(function() {

    $('.eventForm').submit(function(event){
        event.preventDefault();

        if (confirm("Before submitting, is all of the event information correct? \n To make changes, press cancel.")) {
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
                failure:function(data) {
                    alert("Post failed! Error msg: " + data);
                }
            })
        }

    })
    
});