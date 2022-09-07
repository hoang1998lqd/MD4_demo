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
            pagination(data)
        }
    })
}

let perPage = 6;
let currenPage = 1;
let start = 0;
let end = perPage;
let totalPage = 5;

let btnNext = document.querySelector('.btn-next');
let btnPrev = document.querySelector('.btn-previous');

function pagination(list) {
    let content = ""
    content += "<li><a onclick='previousPage()' class='btn-previous'><i class='fa fa-angle-left'></i></a></li>"
    for (let i = 1; i <= Math.ceil((list.length)/perPage); i++) {
        content += "<li><a onclick='nextNumber(" + i + ")' >" + i + "</a></li>"
    }
    content += " <li><a onclick='nextPage()' class='btn-next'><i class='fa fa-angle-right'></i></a></li>"
    document.getElementById("pagination").innerHTML = content
}

function infoPage(text) {
    document.getElementById("infoPage").innerHTML = "Trang" + text + "(Tổng: " + totalPage + " trang)"
}

nextNumber(1)

function nextNumber(number) {
    currenPage = number;
    start = (currenPage - 1) * perPage
    end = currenPage * perPage
    getProducts()
    infoPage(number)

}

function nextPage() {
    currenPage++;
    if (currenPage > totalPage) {
        currenPage = totalPage
    }
    start = (currenPage - 1) * perPage
    end = currenPage * perPage
    getProducts()
    infoPage(currenPage)
}

function previousPage() {
    currenPage--;
    if (currenPage <= 1) {
        currenPage = 1
    }
    start = (currenPage - 1) * perPage
    end = currenPage * perPage
    getProducts()
    infoPage(currenPage)
}

// btnPrev.addEventListener('click', ()=>{
//     currenPage--;
//     if (currenPage <= 1){
//         currenPage = 1
//     }
//     start = (currenPage - 1) * perPage
//     end = currenPage * perPage
//     getProducts()
// })
function loadTable(list) {
    let content = "";
    for (let i = start; i < end; i++) {
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
                "                                                        <p><span class=\"price\">" + changePrice(list[i].product.price) + "</span></p>\n" +
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
    document.getElementById("products-page").innerHTML = content;
}

function changePrice(n) {
    const formatter = new Intl.NumberFormat('it-IT', {
        style: 'currency',
        currency: 'VND',
        // minimumFractionDigits: 2
    })
    return formatter.format(n);
}

// itemPerPage = 6
// currenPage = 1
// start = 0, end = itemPerPage
// start = (currenPage - 1) * itemPerPage
// end = currenPage * itemPerPage

// let perPage = 6;
// let currenPage = 1;
// let start = 0;
// let end = perPage;
// let totalPage;


// btnNext.addEventListener('click', ()=>{
//     currenPage++;
//     start = (currenPage - 1) * perPage
//     end = currenPage * perPage
//         getProducts();
// })