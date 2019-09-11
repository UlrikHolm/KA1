console.log('hello from new project');
const persons = ["Henrik","Helge","Hans","Holger"];
const root = document.getElementById('root');
const btn1 = document.getElementById('btn1');
btn1.onclick = function(){
    const url = 'https://api.chucknorris.io/jokes/random';    
    //const p = persons.map(function(el){return '<li>' + el + '</li>'});
    //const p = persons.map(el=>'<li>'+ el + '</li>');
    //console.log('Jeg blev klikket');
    //root.innerHTML = '<ul>' + p.join(""); + '</ul>'

    fetch(url)
    .then(function(response){return response.json()})
    .then(function(data){
        root.innerHTML = data.value
    });
}

