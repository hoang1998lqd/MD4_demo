function loginCustomer(){
    let emailAddress = $('#input-email').val()
    let password = $('#input-password').val()

    let customer = {
        emailAddress: emailAddress,
        password: password,
    }

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(customer),
        url: "http://localhost:8081/api/customers/login",
        success: function (data) {

        }
    })
}