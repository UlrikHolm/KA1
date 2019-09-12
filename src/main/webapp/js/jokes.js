
var jokeTable = document.getElementById('joke_table');

//'<tr>\
//    <th scope="row">1</th>\
//    <td></td>\
//    <td>Otto</td>\
//    <td>@mdo</td>\
//</tr>'



let url = 'https://jjugroup.ga/KA1/api/joke/all';
fetch(url)
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