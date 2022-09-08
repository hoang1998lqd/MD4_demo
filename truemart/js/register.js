function createCustomer() {
    let name = $('#name').val()
    let emailAddress = $('#email').val()
    let password = $('#pwd').val()
    let phoneNumber = $('#number').val()
    let address = $('#address').val()
    let customer = {
        emailAddress: emailAddress,
        password: password,
        name: name,
        phoneNumber: phoneNumber,
        address: address,
        status: 1,
        role: [
            {
                id: 2
            }
        ]

    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(customer),
        url: "http://localhost:8081/api/customers/signup",
        success: function () {
            document.getElementById("messageCreate").innerHTML = "Tạo mới thành công!"
        }
    })
    event.preventDefault()
}
