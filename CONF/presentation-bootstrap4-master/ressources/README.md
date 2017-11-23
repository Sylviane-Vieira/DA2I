# Compile SCSS Without installing anything

Download jruby complete:
```
curl -O https://s3.amazonaws.com/jruby.org/downloads/9.1.13.0/jruby-complete-9.1.13.0.jar
```
Now rename it:
```
mv jruby-complete-9-1-13.0.jar scss.jar
```
Next install gems:
```
java -jar scss.jar -S gem install -i gems sass --no-document --no-format-executable
java -jar scss.jar -S gem install -i gems bourbon --no-document --no-format-executable
java -jar scss.jar -S gem install -i gems neat --no-document --no-format-executable
```

Finally bundle it:
```
jar uf scss.jar -C gems .
```
The new jar File can now be used like this:
```
java -jar scss.jar -S scss styles.scss > style.css
```

# Couleurs

- blue : #199EB8
- orange : #E04F00

# Fonts à ajouter
- Fontawesome : http://fontawesome.io/

