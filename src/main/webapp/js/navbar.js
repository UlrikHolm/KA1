var navbar = '\
<div class="container">\
  <a class="navbar-brand" href="#">JJU Group</a>\
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">\
    <span class="navbar-toggler-icon"></span>\
  </button>\
  <div class="collapse navbar-collapse" id="navbarResponsive">\
    <ul class="navbar-nav ml-auto">\
      <li class="nav-item active">\
        <a class="nav-link" href="#">Home\
          <span class="sr-only">(current)</span>\
        </a>\
      </li>\
      <li class="nav-item">\
        <a class="nav-link" href="wdw.html">Who did what</a>\
      </li>\
      <li class="nav-item">\
        <a class="nav-link" href="joke.html">Cool Joke</a>\
      </li>\
      <li class="nav-item">\
        <a class="nav-link" href="https://github.com/UlrikHolm/KA1">Github Repo</a>\
      </li>\
      <li class="nav-item">\
            <a class="nav-link" href="car.html">Car Sale</a>\
        </li>\
    </ul>\
  </div>\
</div>'

document.getElementById("nav").innerHTML=navbar;