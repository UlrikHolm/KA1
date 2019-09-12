
var carTable = document.getElementById('car_table');

var cars = [
    { id: 1, year: 1997, make: 'Ford', model: 'E350', price: 3000 },
    { id: 2, year: 1999, make: 'Chevy', model: 'Venture', price: 4900 },
    { id: 3, year: 2000, make: 'Chevy', model: 'Venture', price: 5000 },
    { id: 4, year: 1996, make: 'Jeep', model: 'Grand Cherokee', price: 4799 },
    { id: 5, year: 2005, make: 'Volvo', model: 'V70', price: 44799 }
  ];

function mapper(array){

    var c = array.map(el=>'<tr><td>'+el.id+'</td>\n\
    <td>'+el.year+'</td>\n\
    <td>'+el.make+'</td>\n\
    <td>'+el.model+'</td>\n\
    <td>'+el.price+'</td></tr>');
    return c.join('');
}

//console.log(mapper(cars))
carTable.innerHTML = mapper(cars);

let url = 'http://localhost:8080/ka1/api/student/all';
/* fetch(url)
    .then(res => res.json())
    .then(data => { */
/*         var i;
        for (i = 0; i < cars.length; i++) {
            carTable.innerHTML += '<tr><td>' + cars[i].id +'</td>\
            <td>' + cars[i].year + '</td>\
            <td>' + cars[i].make + '</td>\
            <td>' + cars[i].model + '</td>\
            <td>' + cars[i].price + '</td></tr>'
        } */
/*     } ) */

var filteredcars = cars;

btn1.onclick = function(){
    var input = document.getElementById("input1").value;
if (input === ''){
    alert('Please enter something!')
} else {
    filteredcars = cars.filter(function(el){return el.price <= input});
    carTable.innerHTML = mapper(filteredcars);
}
/*     filteredcars = cars.filter(function(el){return el.price <= input});
    carTable.innerHTML = mapper(filteredcars); */
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