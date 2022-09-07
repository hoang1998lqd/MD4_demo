getProducts()

function loadCategories() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/api/categories",
        success: function (data) {
            let content = ""
            content += ' <option >' + "---" +
                '</option>'
            for (let i = 0; i < data.length; i++) {
                content += ' <option value="' + data[i].id + '">' + data[i].name +
                    '</option>'
            }
            document.getElementById("select-category").innerHTML = content;
        }
    })
}

function getProducts() {
    // products = new Map();
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/api/products",
        success: function (data) {
            for (let i = 0; i < data.length; i++) {
                // products.set(data[i].product.id, data[i].product);
                localStorage.setItem(data[i].product.id, data[i].imageURLS[1])
            }
            loadTable(data)
        }
    })
}

function loadTable(list)    {
    let content = "";
    for (let i = (list.length - 1); 0 <= i; i--) {
        if (list[i].product.status !== 0) {
            content += " <div class='col-lg-4 col-md-4 col-sm-6 col-6'>\n" +
                "                                            <div class=\'single-product\'>\n" +
                "                                                <div class=\'pro-img\'>\n" +
                "                                                    <a href=\'product.html\'>\n" +
                "                                                        <img class=\'primary-img\' src=\'" + list[i].imageURLS[0] + "' alt=\'single-product\'>\n" +
                "                                                        <img class=\"secondary-img\" src=\'" + list[i].imageURLS[1] + "' alt=\'single-product\'>\n" +
                "                                                    </a>\n" +
                "                                                    <a href=\"#\" class=\"quick_view\" data-toggle=\"modal\" data-target=\"#myModal\" title=\"Quick View\"><i class=\"lnr lnr-magnifier\"></i></a>\n" +
                "                                                </div>\n" +
                "                                                <!-- Product Image End -->\n" +
                "                                                <!-- Product Content Start -->\n" +
                "                                                <div class=\"pro-content\">\n" +
                "                                                    <div class=\"pro-info\">\n" +
                "                                                        <h4><a href=\"product.html\">" + list[i].product.name + "</a></h4>\n" +
                "                                                        <p><span class=\"price\">" + changePrice(list[i].product.price)  + "</span></p>\n" +
                "                                                        <div class=\"label-product l_sale\">10<span class=\"symbol-percent\">%</span></div>\n" +
                "                                                    </div>\n" +
                "                                                    <div class=\"pro-actions\">\n" +
                "                                                        <div class=\"actions-primary\">\n" +
                // "                                                            <button    title=\"Add to Cart\"> + Add To Cart</button>\n" +
                "                                                           <a onclick='createItem("+ list[i].product.id  +", 1)' title=\"\" data-original-title=\"Add to Cart\"> + Thêm vào giỏ</a> " +
                "                                                        </div>\n" +
                "                                                        <div class=\"actions-secondary\">\n" +
                "                                                            <a href=\"compare.html\" title=\"Compare\"><i class=\"lnr lnr-sync\"></i> <span>Add To Compare</span></a>\n" +
                "                                                            <a href=\"wishlist.html\" title=\"WishList\"><i class=\"lnr lnr-heart\"></i> <span>Add to WishList</span></a>\n" +
                "                                                        </div>\n" +
                "                                                    </div>\n" +
                "                                                </div> " +
                "                                                </div> " +
                "                                                </div> "
        }
    }
    document.getElementById("products").innerHTML = content;
}

function changePrice(n){
    const formatter = new Intl.NumberFormat('it-IT', {
        style: 'currency',
        currency: 'VND',
        // minimumFractionDigits: 2
    })
    return  formatter.format(n);
}

//Create Item
function createItem(idProduct,idCustomer) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/api/carts/item/" + 1,
        success: function (data) {
            for (let i = 0; i < data.length; i++) {
                if (data[i].product.id == idProduct){
                    data[i].quantity += 1 ;
                }
            }
        }
    })
    let quantity = 1;
    let item = {
        quantity : quantity,
        cart:{
            id: idCustomer
        },
        product:{
            id: idProduct
        }
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(item),
        //tên API
        url: "http://localhost:8081/api/carts/item",
        //xử lý khi thành công
        success: function () {
            addItemSuccess()
            getItemByCustomerId(idCustomer)
        }
    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}

function addItemSuccess() {
    Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Đã thêm vào giỏ hàng',
        showConfirmButton: false,
        timer: 1500
    })
}

// Create Cart
function createCart(idCustomer) {
    let cart ={
        customer:{
            id: idCustomer
        }
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(cart),
        //tên API
        url: "http://localhost:8081/api/carts",
        //xử lý khi thành công
        success: function () {
        }
    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}

// TÌm kiếm Item theo ID người dùng
getItemByCustomerId(1)
function getItemByCustomerId(idCustomer) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/api/carts/item/" + 1,
        success: function (data) {
            displayItem(data);
            displayItemInCart(data)
        }
    })
}

// Lấy ảnh ID sản phẩm

function getImageURL(idProduct) {

    for (let i = 0; i < products.length; i++) {
        if (products[i].product.id === idProduct){
            // console.log(products[i].imageURLS[1])
            console.log(products[i].product.name)
        }
    }
}

function displayItem(items) {
    let countItem = 0;
    let subtotal = 0;
    let content = "";
    for (let i = 0; i < items.length; i++) {
        content += "<div class=\"single-cart-box\">\n" +
            "       <div class=\"cart-img\">\n" +
            "       <a href=\"#\"><img src=" + localStorage.getItem(items[i].product.id )+ " alt=\"cart-image\"></a>\n" +
            "           <span class=\"pro-quantity\">" + items[i].quantity + "</span>\n" +
            "         </div>\n" +
            "         <div class=\"cart-content\">\n" +
            "          <h6><a href=\"product.html\">  " + items[i].product.name + "   </a></h6>\n" +
            "             <span class=\"cart-price\"> " + changePrice(items[i].product.price ) + " </span>\n" +
            // "             <span>Size: S</span>\n" +
            "            <span> " + items[i].product.color + "</span>\n" +
            "             </div>\n" +
            "                <a class=\"del-icone\" href=\"#\"><i class=\"ion-close\" onclick='deleteItem("+items[i].id +")'></i></a>\n" +
            "           </div>"
    }
    for (let i = 0; i < items.length; i++) {
        let totalItem = (items[i].product.price - (items[i].product.price * items[i].product.discount)/100 )* items[i].quantity;
        subtotal += totalItem
        countItem ++;
    }
    localStorage.setItem("count-item", countItem)
    let discount = 0;
    let ship = 0;
    content += "<div class=\"cart-footer\">\n" +
        "         <ul class=\"price-content\">\n" +
        "           <li>Thành tiền <span>"+ changePrice(subtotal) +"</span></li>\n" +
        // "       <li>Khuyến mãi <span>"+ discount+"</span></li>\n" +
        "              <li>Phí Ship <span>"+ ship+"</span></li>\n" +
        "          <li>Thanh toán <span>"+ changePrice(subtotal - discount - ship) +"</span></li>\n" +
        "         </ul>\n" +
        "            <div class=\"cart-actions text-center\">\n" +
        "        <a class=\"cart-checkout\" href=\"cart.html\">Thanh toán</a>\n" +
        "       </div>\n" +
        "         </div>"
    document.getElementById('display-item-shop').innerHTML = content
    document.getElementById('count-item').innerHTML = localStorage.getItem("count-item")
}




// Xóa Item khỏi Cart khi người dùng không muốn mua nó nữa
function deleteItem(idItem) {
    Swal.fire({
        title: 'Bạn có chắc muốn xóa ?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Xóa!'
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire(
                'Xóa!',
                'Sản phẩm đã được xóa khỏi giỏ hàng.',
                'success',
                $.ajax({
                    type: "DELETE",
                    url: "http://localhost:8081/api/carts/item/" + idItem,
                    success: function () {
                        Swal.fire({
                            position: 'top-end',
                            icon: 'success',
                            title: 'Xóa thành công',
                            showConfirmButton: false,
                            timer: 1500
                        })
                        getItemByCustomerId()
                    }

                })
            )
        }
    })
}


// Hiển thị Item ở trên trang giỏ hàng

function displayItemInCart(items) {
    let subtotal = 0;
    let content = "";
    for (let i = 0; i <items.length ; i++) {
        content += " <tr>"
        content += " <td class=\"product-thumbnail\">\n" +
            "    <a href=\"#\"><img src=" + localStorage.getItem(items[i].product.id )+ " alt=\"cart-image\" /></a>\n" +
            "      </td>\n" +
            "  <td class=\"product-name\"><a href=\"#\">"+ items[i].product.name +"</a></td>\n" +
            "    <td class=\"product-price\"><span class=\"amount\">"+ items[i].product.price +"</span></td>\n" +
            "  <td class=\"product-quantity\"><input type=\"number\" value="+ items[i].quantity +" /></td>\n" +
            "    <td class=\"product-subtotal\">"+ items[i].product.price * items[i].quantity +"</td>\n" +
            "   <td class=\"product-remove\"> <a href=\"#\"><i class=\"fa fa-times\" aria-hidden=\"true\" onclick='deleteItem("+items[i].id +")'></i></a></td>"
        content += "</tr>"
    }
    for (let i = 0; i < items.length; i++) {
        let totalItem = (items[i].product.price - (items[i].product.price * items[i].product.discount)/100 )* items[i].quantity;
        subtotal += totalItem
    }
    let result = "";
    result += "<div class=\"cart_totals float-md-right text-md-right\">\n" +
        "                                        <h2>Tổng tiền giỏ hàng</h2>\n" +
        "                                        <br />\n" +
        "                                        <table class=\"float-md-right\">\n" +
        "                                            <tbody>\n" +
        "                                                <tr class=\"cart-subtotal\">\n" +
        "                                                    <th>Thành tiền</th>\n" +
        "                                                    <td><span class=\"amount\">"+ changePrice(subtotal) +"</span></td>\n" +
        "                                                </tr>\n" +
        "                                                <tr class=\"order-total\">\n" +
        "                                                    <th>Tổng tiền</th>\n" +
        "                                                    <td>\n" +
        "                                                        <strong><span class=\"amount\">"+ changePrice(subtotal) +"</span></strong>\n" +
        "                                                    </td>\n" +
        "                                                </tr>\n" +
        "                                            </tbody>\n" +
        "                                        </table>\n" +
        "                                        <div class=\"wc-proceed-to-checkout\">\n" +
        "                                            <a href=\"#\">Tiến hành thanh toán</a>\n" +
        "                                        </div>\n" +
        "                                    </div>"
    document.getElementById('display-item-cart').innerHTML = content
    document.getElementById('checkout-item').innerHTML = result
}




// Thanh toán đơn hàng

















// Thanh toán đơn hàng
