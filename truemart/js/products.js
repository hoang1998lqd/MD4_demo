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
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/api/products",
        success: function (data) {
            console.log(data)
            loadTable(data)
        }
    })
}

function loadTable(list) {
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
                "                                                            <a href=\"cart.html\" title=\"Add to Cart\"> + Add To Cart</a>\n" +
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

