var jokeTable = document.getElementById('joke_table');
var joke = document.getElementById('joke');
var source = document.getElementById('source');
var btn1 = document.getElementById('btn1');
var url = 'https://jjugroup.ga/KA1/api/joke/';


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
    .then(dataJokeR => {
      
        randJoke.innerHTML = dataJokeR.joke;
        source.innerHTML = dataJokeR.reference;
    } )}

//http://localhost:8080/ka1/api/joke/
    btn2.onclick = function(){
        var inputJ = document.getElementById("ij").value;
        let urlInput = url+inputJ;
        fetch(urlInput)
        .then(res => res.json())
        .then(dataJoke => {
          
            randJoke.innerHTML = dataJoke.joke;
            source.innerHTML = dataJoke.reference;
        } )}