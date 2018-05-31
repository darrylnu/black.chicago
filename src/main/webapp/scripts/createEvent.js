$(document).ready(function() {

    $('.eventForm').submit(function(event){
        event.preventDefault();
        var $formInfo = $('.eventForm').serialize();
        console.log($formInfo);

        $.ajax({
            url:"CreateEventServlet",
            data: $formInfo,
            type: 'post',
            success:function(data) {
                console.log(data);
            }
        })
    })
    
});