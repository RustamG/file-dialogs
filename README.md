# File Dialogs
Android library with save and open file dialogs.


## Features
1. **Open file dialog**
![Open](./images/Open.png)

2. **Save file dialog**
![Save](./images/Save.png)

## Usage
```java
// You can use either OpenFileDialog or SaveFileDialog depending on your needs
FileDialog dialog = new OpenFileDialog();
dialog.setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Your_Theme);
dialog.show(getSupportFragmentManager(), OpenFileDialog.class.getName());
```
**Specifying file extension**

If you need to show files with specific extension add the following lines before showing the dialog:

```java
Bundle args = new Bundle();
args.putString(FileDialog.EXTENSION, "png"); // file extension is optional
dialog.setArguments(args);
```

To receive callbacks when user selected a file (either for open or save) make your fragment or activity implement ```FileDialog.OnFileSelectedListener```.


**Changing Toolbar icons color**

In order to change the color of icons in a toolbar, add the following item to your theme declaration:
```xml
<item name="file_dialog_toolbar_icons_color">#ff3f4aff</item>
```
![Colored_icons](./images/Colored_icons.png)

Please refer to the sample project to see how it works.

## Download
Gradle:
```groovy
    compile 'com.github.rustamg:file-dialogs:0.1.2'
```

Maven:
```xml
<dependency>
  <groupId>com.github.rustamg</groupId>
  <artifactId>file-dialogs</artifactId>
  <version>0.1.2</version>
  <type>aar</type>
</dependency>
```
