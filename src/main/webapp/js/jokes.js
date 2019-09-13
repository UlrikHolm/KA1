
var jokeTable = document.getElementById('joke_table');
var joke = document.getElementById('joke');
var source = document.getElementById('source');
var btn1 = document.getElementById('btn1');
var url = 'https://jjugroup.ga/KA1/api/joke/';

//'<tr>\
//    <th scope="row">1</th>\
//    <td></td>\
//    <td>Otto</td>\
//    <td>@mdo</td>\
//</tr>'


//http://localhost:8080/ka1/api/joke/all
let urlAll = url+"all";
fetch(urlAll)
    .then(res => res.json())
    .then(data => {
        var i;
        for (i = 0; i < data.length; i++) {
            
            jokeTable.innerHTML += '<tr><td>' + data[i].joke +'</td>\
            <td>' + data[i].reference + '</td>\
            <td>' + data[i].type + '</td></tr>'
            console.log(data.length);
        }
    } )

//http://localhost:8080/ka1/api/joke/random
    btn1.onclick = function(){
    let urlRand = url+"random";
    fetch(urlRand)
    .then(res => res.json())
    .then(dataJoke => {
      
            joke.innerHTML = dataJoke.joke;
            source.innerHTML = dataJoke.reference;
    } )}

//http://localhost:8080/ka1/api/joke/
    btn1.onclick = function(){
        let urlInput = url+input;
        fetch(urlInput)
        .then(res => res.json())
        .then(dataJoke => {
          
                joke.innerHTML = dataJoke.joke;
        } )}