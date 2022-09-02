let idProduct;

function createProduct() {
    let name = $('name').val()
    let price = $('price').val()
    let amount = $('amount').val()
    let color = $('color').val()
    let description = $('description').val()
    let status = $('status').val()
    let discount = $('discount').val()
    let brand_id = $('brands').val()
    let category_id = $('categories').val()

    let product = {
        name: name,
        price: price,
        amount: amount,
        color: color,
        description: description,
        status: status,
        discount: discount,
        brand: {
            id: brand_id
        },
        category: {
          id: category_id
        }
    }
    $.ajax({
        contentType: false,
        processData: false,
        type: "POST",
        url: "http//localhost:8083/products",
        success: function () {
            $('#myModal').modal('hide');
        }
    })
}