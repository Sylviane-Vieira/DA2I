
# SASS


## Qu'est ce que SASS ?

- **S**yntactically **A**wesome **S**tyle**S**heet
- Un préprocésseur
- Genère des feuilles de style (CSS)


## Partials

```scss
@import "./unAutreFichier";

```


## Variables

```scss
$blue: #1761A4;

p {
  color : $blue;
}
```


## Arborescence

```scss
p {
    &.blue {
        color: #1761A4;
        &:hover {
            color: #FF0000;
        }
    }
}

// p.blue { color: #1761A4 }
// p.blue:hover { color: #FF0000 }
```


## Mixins
```scss
@mixin border-radius($radius){
  -webkit-border-radius: $radius;
  -moz-border-radius: $radius;
  border-radius: $radius;
}

p { @include border-radius(10px); }
```


## Héritage
```scss
.btn{
  border:0;
  background: #fff;
}

.btn-success {
  @extend .btn;
  background: #26751F;
}
```


## Opérateurs
```scss
    div {
      width: 600px / 960px * 100%;
    }
```


## Media
```scss
.sidebar {
  width:100px;
  @media screen and (max-width: 600px) {
    width: 20%;
  }
}
```