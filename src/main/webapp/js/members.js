
var memberTable = document.getElementById('member_table');

//'<tr>\
//    <th scope="row">1</th>\
//    <td></td>\
//    <td>Otto</td>\
//    <td>@mdo</td>\
//</tr>'



let url = 'http://localhost:8080/ka1/api/student/all';
fetch(url)
    .then(res => res.json())
    .then(data => {
        var i;
        for (i = 0;  data.length; i++) {
            
            memberTable.innerHTML += '<tr><td>' + data[i].name +'</td>\
            <td>' + data[i].studentID + '</td>\
            <td>' + data[i].color + '</td>'
            console.log(data.length);
        }
    } )