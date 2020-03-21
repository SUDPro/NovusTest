var firstCat = document.getElementById('firstCat');
var firstCatName = document.getElementById('nameFirst');
var firstPhoto = document.getElementById('photoFirst');
var secondCat = document.getElementById('secondCat');
var secondCatName = document.getElementById('nameSecond');
var secondPhoto = document.getElementById('photoSecond');
var arrOfCats;

$(document).ready(function () {
    loadCats()
});

function loadCats() {
    $.ajax({
        url: "/api/getCats",
        method: "get",
        success: function (cats) {
            arrOfCats = cats;
            showCats();
        }
    });
}

function showCats() {
    if (arrOfCats.length > 0) {
        firstCatName.innerHTML = arrOfCats[0].name;
        secondCatName.innerHTML = arrOfCats[1].name;
        firstCatName.setAttribute("data-identifier", arrOfCats[0].id);
        firstPhoto.setAttribute("src", arrOfCats[0].photoPath);
        secondCatName.setAttribute("data-identifier", arrOfCats[1].id);
        secondPhoto.setAttribute("src", arrOfCats[1].photoPath);
        deleteCatsFromArray();
    } else {
        window.location.href = "/top";
    }
}

function deleteCatsFromArray() {
    arrOfCats.splice(0, 2);
}

function voteForCat(identifier) {
    $.ajax({
        url: "/api/voteCat",
        method: "post",
        data: {
            'id': identifier
        },
        success: function () {
            showCats();
        },
        error: function () {
            alert("Извините, котик был удалён или перемещён, за него пока нельзя голосовать :(");
            showCats();
        }
    });
}

$(firstCat).click(function () {
    voteForCat(firstCatName.getAttribute("data-identifier"));
});

$(secondCat).click(function () {
    voteForCat(secondCatName.getAttribute("data-identifier"));
});