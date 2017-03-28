# File Dialogs
Android library with save and open file dialogs.


## Features
**Open file dialog** | **Save file dialog**
-------------------- | --------------------
<img src="https://github.com/RustamG/file-dialogs/raw/master/images/Open.png" height="260" /> | <img src="https://github.com/RustamG/file-dialogs/raw/master/images/Save.png" height="260" />



## Usage
```java
// You can use either OpenFileDialog or SaveFileDialog depending on your needs
FileDialog dialog = new OpenFileDialog();
dialog.setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Your_Theme);
dialog.show(getSupportFragmentManager(), OpenFileDialog.class.getName());
```
#### Specifying file extension

If you need to show files with specific extension add the following lines before showing the dialog:

```java
Bundle args = new Bundle();
args.putString(FileDialog.EXTENSION, "png"); // file extension is optional
dialog.setArguments(args);
```

To receive callbacks when user selected a file (either for open or save) make your fragment or activity implement ```FileDialog.OnFileSelectedListener```.


#### Changing Toolbar icons color

In order to change the color of icons in a toolbar, add the following item to your theme declaration:
```xml
<item name="file_dialog_toolbar_icons_color">#ff3f4aff</item>
```

<img src="https://github.com/RustamG/file-dialogs/raw/master/images/Colored_icons.png" height="260" />

Please refer to the sample project to see how it works.

For more detailed toolbar customization please use toolbarStyle item (without ```android:``` prefix) in the theme that is used for the dialog.

## Download
Gradle:
```groovy
    compile 'com.github.rustamg:file-dialogs:1.0'
```

Maven:
```xml
<dependency>
  <groupId>com.github.rustamg</groupId>
  <artifactId>file-dialogs</artifactId>
  <version>1.4</version>
  <type>aar</type>
</dependency>
```

### MIT License

```
    The MIT License (MIT)

    Copyright (c) 2015 Rustam Gilyaev

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.
```
