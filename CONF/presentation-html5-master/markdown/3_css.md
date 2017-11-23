
# CSS


## Qu'est ce que CSS ?


- un language de description
- **C**ascade **S**tyle**C**heet
- 1ère version : 1990


## Représentation ? 

```css
#monId .maClasse div
{
    /** Propriétés */
}

.maClasse div{
    /** D'autres propriétés **/
}
```


## Les propriétés de texte

```css
.monSelecteur{
    font-family: "Lato", sans-serif;
    font-size:1em; /* em, rem, px */
    font-weight: lighter; /*lighter, normal, bolder, bold*/
    text-decoration: underline; /*none, underline, overline, line-through */
    color:#1a53a1; /* #000000, rgb(000,000,000), rgba(000,000,000,0) */    
}
```


## Les propriétés de mise en form
```css
.monSelecteur{
    background: url('monimage.jpg') no-repeat center #000000; /*#000000, rgb(000,000,000), rgba(000,000,000,0) */
    border: 1px solid black;
    -webkit-border-radius: 1em; /*Propriété expérimental pour les anciens navigateurs*/
    -moz-border-radius: 1em; /*Propriété expérimental pour les anciens navigateurs*/
    border-radius: 1em;
    margin: 1em;
    Padding: 1em;
    width:100%;
    height:100vh;
}
```


## Les propriétés de positions

```css
.monSelecteur{
    position: relative;
}
.monSelecteur2{
    position: absolute;
    top: 1em;
    left: 1em;
}
.monSelecteur3{
    float: left;
}
```


### Les nouveauté de CSS 3 !
```css
.monSelecteur{
    width:100%;
}
@media screen and (max-width: 640px) {
    .monSelecteur{
        width:50%;
    }
}
```


```css
@font-face {
    font-family: "Lato";
    src: url('/fonts/Lato-Regular.eot');
    src: url('/fonts/Lato-Regular.woff2') format('woff2'),
         url('/fonts/Lato-Regular.otf')   format('truetype'),
         url('/fonts/Lato-Regular.woff')  format('woff');
    font-weight: normal;
    font-style: normal;
}
```


```css
@keyframes monAnimation {
    from {
        background-color:#000000;
    }
    to {
        background-color: #ffffff;
    }
}

div {
    width:100px;
    height:100px;
    background-color: #000000;
    animation-name: monAnimation;
    animation-delay: 4s;
}
```


### liens utiles 
- w3schools.com
- codepen.io
- csszengarder.com