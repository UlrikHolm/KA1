var url = 'https://jjugroup.ga/KA1/api/car/'
//'https://jjugroup.ga/KA1/api/car/'

var carTable = document.getElementById('car_table');

function mapper(array){

    var c = array.map(el=>'<tr><td>'+el.id+'</td>\n\
    <td>'+el.year+'</td>\n\
    <td>'+el.make+'</td>\n\
    <td>'+el.model+'</td>\n\
    <td>'+el.price+'</td></tr>');
    return c.join('');
}

var cars;
//console.log(mapper(cars))
//carTable.innerHTML = mapper(cars);
window.onload = allCars;
var urlAll = url + 'all';

function allCars(){
fetch(urlAll)
    .then(res => res.json())
    .then(data => {
        carTable.innerHTML = mapper(data);
        cars = data;
        filteredcars = cars;
        });
    };

var filteredcars = cars;

btn1.onclick = function(){
    var inputFrom = document.getElementById("input1").value;
    var inputTo = document.getElementById("input2").value;
if (inputFrom === '' || inputTo === ''){
    if(inputFrom === ''){
    alert('Please enter min price!')
    }if (inputTo === ''){
    alert('Please enter max price!')
    }
} else {
    filteredcars = cars.filter(function(el){return el.price >= inputFrom && el.price <= inputTo});
    carTable.innerHTML = mapper(filteredcars);
}
};

function sorter(sortBy){
    var key = sortBy;
        function compare(a, b) {
            const comA = a[key];
            const comB = b[key];
            let comparison = 0;
            if (comA > comB) {
            comparison = 1;
            } else if (comA < comB) {
            comparison = -1;
            }
            return comparison;
        }
  return compare;
}

btn2.onclick = function(){
    var select = document.getElementById("inputGroupSelect01");
    var selectedSort = select.options[select.selectedIndex].value;
    carTable.innerHTML = mapper(filteredcars.sort(sorter(selectedSort)));

    //console.log(cars.sort(dynamicSort(selectedSort)));

    //console.log(selectedSort);
    
};


btn3.onclick = function(){
    var inputMake = document.getElementById("input3").value;
    if(inputMake === ''){
    alert('Please enter make')
    }
     else {
        var urlMake = url + 'make/' + inputMake;
        fetch(urlMake)
        .then(res => res.json())
        .then(data => {
        carTable.innerHTML = mapper(data);
        cars = data;
        filteredcars = cars;
        });

    carTable.innerHTML = mapper(filteredcars);
}
};

btn4.onclick = allCars;