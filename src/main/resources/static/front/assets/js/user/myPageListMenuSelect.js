let $ListSelect = $('.inner_snb li a');

$.each($ListSelect, function (i, e) {
    let index = 0;
    $(e).click(function () {
        index = i

        for (let j = 0; j < $ListSelect.length; j++){
            $ListSelect[j].classList.remove("on")
        }

        $ListSelect[index].classList.add("on");
    });
});