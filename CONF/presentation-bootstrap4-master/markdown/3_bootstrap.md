# Twitter Bootstrap 4


## Qu'est ce que Bootstrap ? 

- un framework css
- Prototypage rapide
- Flexible
- V1 : 2011


## Fondamental
```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <link rel="stylesheet" href="./style.css">
    </head>
    <body>
        <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    </body>
</html>
```
```bash
npm install bootstrap@4.0.0-alpha.6
```
```scss
@import "./node_modules/bootstrap/scss/bootstrap";
```


## Breakpoint
```scss
    /**
     * Nombre de colonne min : 1
     * Nombre de colonne max : 12
     * Padding : 15px 0; 
     */
     div {
      @extend .container
         p {
            @extend .col-3;     // @screen < 576px
            @extend .col-sm-12; // @screen >= 576px && @screen < 768px
            @extend .col-md-12; // @screen >= 768px && @screen < 992px
            @extend .col-lg-3;  // @screen >= 992px && @screen < 1200px
            @extend .col-xl-1;  // @screen >= 1200 px
         }
     }
```


## alignement vertical
```html
<div class="container">
    <!-- 
        .align-items-start
        .align-items-center
        .align-items-end
    -->
    <div class="row align-items-center">
        <div class="col"></div>
        <div class="col"></div>
        <div class="col"></div>
    </div>
</div>
```


### Overriding / Theme
```scss
$body-bg: #000;
$body-color: #111;
$grid-columns: 24;
@import "./node_modules/bootstrap/scss/bootstrap";
```


### Composants
- slider
- modal
- formulaire
- navbar
- ...

