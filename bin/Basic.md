<!--
 * @Author: fengsc
 * @Date: 2022-02-27 12:23:06
 * @LastEditTime: 2022-02-28 14:00:10
-->
# I/O

## 输入输出流

### 输入流

Java 流相关的类都封装在 java.io 包中，而且每个数据流都是一个对象。所有输入流类都是 InputStream 抽象类（字节输入流）和 Reader 抽象类（字符输入流）的子类。其中 InputStream 类是字节输入流的抽象类，是所有字节输入流的父类，其层次结构如图所示。

<img src="http://c.biancheng.net/uploads/allimg/200115/5-200115145253550.png">

InputStream 类中所有方法遇到错误时都会引发 IOException 异常。如下是该类中包含的常用方法。

<table>
<caption>
<br>
InputStream 类常用方法</caption>
<tbody>
<tr>
<th>
名称</th>
<th>
作用</th>
</tr>
<tr>
<td>
int read()</td>
<td>
从输入流读入一个 8 字节的数据，将它转换成一个 0~ 255 的整数，返回一个整数，如果遇到输入流的结尾返回 -1</td>
</tr>
<tr>
<td>
int read(byte[] b)</td>
<td>
从输入流读取若干字节的数据保存到参数 b 指定的字节数组中，返回的字节数表示读取的字节数，如果遇到输入流的结尾返回 -1</td>
</tr>
<tr>
<td>
int read(byte[] b,int off,int len)</td>
<td>
从输入流读取若干字节的数据保存到参数 b 指定的字节数组中，其中 off 是指在数组中开始保存数据位置的起始下标，len 是指读取字节的位数。返回的是实际读取的字节数，如果遇到输入流的结尾则返回 -1</td>
</tr>
<tr>
<td>
void close()</td>
<td>
关闭数据流，当完成对数据流的操作之后需要关闭数据流</td>
</tr>
<tr>
<td>
int available()</td>
<td>
返回可以从数据源读取的数据流的位数。</td>
</tr>
<tr>
<td>
skip(long n)</td>
<td>
从输入流跳过参数 n 指定的字节数目</td>
</tr>
<tr>
<td>
boolean markSupported()</td>
<td>
判断输入流是否可以重复读取，如果可以就返回 true</td>
</tr>
<tr>
<td>
void mark(int readLimit)</td>
<td>
如果输入流可以被重复读取，从流的当前位置开始设置标记，readLimit 指定可以设置标记的字节数</td>
</tr>
<tr>
<td>
void reset()</td>
<td>
使输入流重新定位到刚才被标记的位置，这样可以重新读取标记过的数据</td>
</tr>
</tbody>
</table>

Java 中的字符是 Unicode 编码，即双字节的，而 **InputerStream 是用来处理单字节的**，在处理字符文本时不是很方便。这时可以使用 Java 的文本输入流 Reader 类，该类是字符输入流的抽象类，即所有字符输入流的实现都是它的子类，该类的方法与 InputerSteam 类的方法类似

在 Java 中所有输出流类都是 OutputStream 抽象类（字节输出流）和 Writer 抽象类（字符输出流）的子类。其中 OutputStream 类是字节输出流的抽象类，是所有字节输出流的父类，其层次结构如图所示。

<img src="http://c.biancheng.net/uploads/allimg/200115/5-200115151G3J0.png">

OutputStream 类是所有字节输出流的超类，用于**以二进制的形式**将数据写入目标设备

<table>
<caption>
OutputStream类的常用方法</caption>
<tbody>
<tr>
<th>
名称</th>
<th>
作用</th>
</tr>
<tr>
<td>
int write(b)</td>
<td>
将指定字节的数据写入到输出流</td>
</tr>
<tr>
<td>
int write (byte[] b)</td>
<td>
将指定字节数组的内容写入输出流</td>
</tr>
<tr>
<td>
int write (byte[] b,int off,int len)</td>
<td>
将指定字节数组从 off 位置开始的 len 字节的内容写入输出流</td>
</tr>
<tr>
<td>
close()</td>
<td>
关闭数据流，当完成对数据流的操作之后需要关闭数据流</td>
</tr>
<tr>
<td>
flush()</td>
<td>
刷新输出流，强行将缓冲区的内容写入输出流</td>
</tr>
</tbody>
</table>

## 系统流

每个 Java 程序运行时都带有一个系统流，系统流对应的类为 java.lang.System。Sytem 类封装了 Java 程序运行时的 3 个系统流，分别通过 in、out 和 err 变量来引用。这 3 个系统流如下所示：

- System.in：标准输入流，默认设备是键盘。
- System.out：标准输出流，默认设备是控制台。
- System.err：标准错误流，默认设备是控制台。


以上变量的作用域为 public 和 static，因此在程序的任何部分都不需引用 System 对象就可以使用它们。

注意：尽管它们通常用于对控制台进行读取和写入字符，但是这些都是字节流。因为**预定义流是没有引入字符流的 Java 原始规范的一部分，所以它们不是字符流而是字节流，但是在 Java 中可以将它们打包到基于字符的流中使用**。

## File类 

File 类不能访问文件内容本身，如果需要访问文件内容本身，则需要使用输入/输出流。

File 类提供了如下三种形式构造方法。

- File(String path)：如果 path 是实际存在的路径，则该 File 对象表示的是目录；如果 path 是文件名，则该 File 对象表示的是文件。
- File(String path, String name)：path 是路径名，name 是文件名。
- File(File dir, String name)：dir 是路径对象，name 是文件名。

<table border="1">
<caption>
<br>
表 1&nbsp; File类的常用方法</caption>
<tbody>
<tr>
<th>
方法名称</th>
<th>
说明</th>
</tr>
<tr>
<td>
boolean canRead()</td>
<td>
测试应用程序是否能从指定的文件中进行读取</td>
</tr>
<tr>
<td>
boolean canWrite()</td>
<td>
测试应用程序是否能写当前文件</td>
</tr>
<tr>
<td>
boolean delete()</td>
<td>
删除当前对象指定的文件</td>
</tr>
<tr>
<td>
boolean exists()</td>
<td>
测试当前 File 是否存在</td>
</tr>
<tr>
<td>
String getAbsolutePath()</td>
<td>
返回由该对象表示的文件的绝对路径名</td>
</tr>
<tr>
<td>
String getName()</td>
<td>
返回表示当前对象的文件名或路径名（如果是路径，则返回最后一级子路径名）</td>
</tr>
<tr>
<td>
String getParent()</td>
<td>
返回当前 File 对象所对应目录（最后一级子目录）的父目录名</td>
</tr>
<tr>
<td>
boolean isAbsolute()</td>
<td>
测试当前 File 对象表示的文件是否为一个绝对路径名。该方法消除了不同平台的差异，可以直接判断 file 对象是否为绝对路径。在 UNIX/Linux/BSD 等系统上，如果路径名开头是一条斜线<code>/</code>，则表明该 File 对象对应一个绝对路径；在 Windows 等系统上，如果路径开头是盘符，则说明它是一个绝对路径。</td>
</tr>
<tr>
<td>
boolean isDirectory()</td>
<td>
测试当前 File 对象表示的文件是否为一个路径</td>
</tr>
<tr>
<td>
boolean isFile()</td>
<td>
测试当前 File 对象表示的文件是否为一个“普通”文件</td>
</tr>
<tr>
<td>
long lastModified()</td>
<td>
返回当前 File 对象表示的文件最后修改的时间</td>
</tr>
<tr>
<td>
long length()</td>
<td>
返回当前 File 对象表示的文件长度</td>
</tr>
<tr>
<td>
String[] list()</td>
<td>
返回当前 File 对象指定的路径文件列表</td>
</tr>
<tr>
<td>
String[]&nbsp;list(FilenameFilter)</td>
<td>
返回当前 File 对象指定的目录中满足指定过滤器的文件列表</td>
</tr>
<tr>
<td>
boolean mkdir()</td>
<td>
创建一个目录，它的路径名由当前 File 对象指定</td>
</tr>
<tr>
<td>
boolean mkdirs()</td>
<td>
创建一个目录，它的路径名由当前 File 对象指定,父目录不存在则创建</td>
</tr>
<tr>
<td>
boolean renameTo(File)</td>
<td>
将当前 File 对象指定的文件更名为给定参数 File 指定的路径名</td>
</tr>
</tbody>
</table>

File 类中有以下两个常用常量：

- *public static final String pathSeparator*：指的是分隔连续多个路径字符串的分隔符，Windows 下指;Linux下指:。例如 java -cp test.jar;abc.jar HelloWorld。
- *public static final String separator*：用来分隔同一个路径字符串中的目录的，指/。例如 C:/Program Files/Common Files。

Windows 的路径分隔符使用反斜线“\”，而 Java 程序中的反斜线表示转义字符，所以如果需要在 Windows 的路径下包括反斜线，则**应该使用两条反斜线或*直接使用斜线“/”*也可以**。Java 程序**支持将斜线当成平台无关的路径分隔符**。

## 二进制I/O

### 字节输入流

InputStream 类及其子类的对象表示字节输入流，InputStream 类的常用子类如下。

- ByteArrayInputStream 类：将字节数组转换为字节输入流，从中读取字节。
- FileInputStream 类：从文件中读取数据。
- PipedInputStream 类：连接到一个 PipedOutputStream（管道输出流）。
- SequenceInputStream 类：将多个字节输入流串联成一个字节输入流。
- ObjectInputStream 类：将对象反序列化。

<table border="1">
<caption>
表 1 InputStream类的常用方法</caption>
<tbody>
<tr>
<th>
方法名及返回值类型</th>
<th>
说明</th>
</tr>
<tr>
<td>
int read()</td>
<td>
从输入流中读取一个 8 位的字节，并把它转换为 0~255 的整数，最后返回整数。<br>
如果返回 -1，则表示已经到了输入流的末尾。为了提高 I/O&nbsp;操作的效率，建议尽量<br>
使用 read() 方法的另外两种形式</td>
</tr>
<tr>
<td>
int read(byte[] b)</td>
<td>
从输入流中读取若干字节<b>(由b的容量决定*)</b>，并把它们保存到参数 b 指定的字节数组中。 该方法返回<br>
读取的字节数。如果返回 -1，则表示已经到了输入流的末尾</td>
</tr>
<tr>
<td>
int read(byte[] b, int off, int len)</td>
<td>
从输入流中读取若干字节，并把它们保存到参数 b 指定的字节数组中。其中，off 指<br>
定在字节数组中开始保存数据的起始下标；len 指定读取的字节数。该方法返回实际<br>
读取的字节数。如果返回 -1，则表示已经到了输入流的末尾</td>
</tr>
<tr>
<td>
void close()</td>
<td>
关闭输入流。在读操作完成后，应该关闭输入流，系统将会释放与这个输入流相关<br>
的资源。注意，InputStream 类本身的 close() 方法不执行任何操作，但是它的许多<br>
子类重写了&nbsp;close() 方法</td>
</tr>
<tr>
<td>
int available()</td>
<td>
返回可以从输入流中读取的字节数</td>
</tr>
<tr>
<td>
long skip(long n)</td>
<td>
从输入流中跳过参数 n 指定数目的字节。该方法返回跳过的字节数</td>
</tr>
<tr>
<td>
void mark(int readLimit)</td>
<td>
在输入流的当前位置开始设置标记，参数 readLimit 则指定了最多被设置标记的字<br>
节数</td>
</tr>
<tr>
<td>
boolean markSupported()</td>
<td>
判断当前输入流是否允许设置标记，是则返回 true，否则返回 false</td>
</tr>
<tr>
<td>
void reset()</td>
<td>
将输入流的指针返回到设置标记的起始处</td>
</tr>
</tbody>
</table>

### 字节输出流

OutputStream 类及其子类的对象表示一个字节输出流。OutputStream 类的常用子类如下。

- ByteArrayOutputStream 类：向内存缓冲区的字节数组中写数据。
- FileOutputStream 类：向文件中写数据。
- PipedOutputStream 类：连接到一个 PipedlntputStream（管道输入流）。
- ObjectOutputStream 类：将对象序列化。

<table border="1">
<caption>
表 2 OutputStream 类的常用方法</caption>
<tbody>
<tr>
<th>
方法名及返回值类型</th>
<th>
说明</th>
</tr>
<tr>
<td>
void write(int b)</td>
<td>
向输出流写入一个字节。这里的参数是 int 类型，但是它允许使用表达式，<br>
而不用强制转换成 byte 类型。为了提高 I/O 操作的效率，建议尽量使用<br>
write() 方法的另外两种形式</td>
</tr>
<tr>
<td>
void write(byte[] b)</td>
<td>
把参数 b 指定的字节数组中的所有字节写到输出流中</td>
</tr>
<tr>
<td>
void write(byte[] b,int off,int len)</td>
<td>
把参数 b 指定的字节数组中的若干字节写到输出流中。其中，off 指定字节<br>
数组中的起始下标，len 表示元素个数</td>
</tr>
<tr>
<td>
void close()</td>
<td>
关闭输出流。写操作完成后，应该关闭输出流。系统将会释放与这个输出<br>
流相关的资源。注意，OutputStream 类本身的 close() 方法不执行任何操<br>
作，但是它的许多子类重写了&nbsp;close() 方法</td>
</tr>
<tr>
<td>
void flush()</td>
<td>
为了提高效率，在向输出流中写入数据时，数据一般会先保存到内存缓冲<br>
区中，只有当缓冲区中的数据达到一定程度时，缓冲区中的数据才会被写<br>
入输出流中。使用 flush() 方法则可以强制将缓冲区中的数据写入输出流，<br>
并清空缓冲区</td>
</tr>
</tbody>
</table>

### 字节数组输入流

ByteArrayInputStream 类可以从内存的字节数组中读取数据，该类有如下两种构造方法重载形式。

- ByteArrayInputStream(byte[] buf)：创建一个字节数组输入流，字节数组类型的数据源由参数 buf 指定。
- ByteArrayInputStream(byte[] buf,int offse,int length)：创建一个字节数组输入流，其中，参数 buf 指定字节数组类型的数据源，offset 指定在数组中开始读取数据的起始下标位置，length 指定读取的元素个数。

### 字节数组输出流

ByteArrayOutputStream 类可以向内存的字节数组中写入数据，该类的构造方法有如下两种重载形式。

- ByteArrayOutputStream()：创建一个字节数组输出流，输出流缓冲区的初始容量大小为 32 字节。
- ByteArrayOutputStream(int size)：创建一个字节数组输出流，输出流缓冲区的初始容量大小由参数 size 指定。


ByteArrayOutputStream 类中除了有前面介绍的字节输出流中的常用方法以外，还有如下两个方法。

- intsize()：返回缓冲区中的当前字节数。
- byte[] toByteArray()：以字节数组的形式返回输出流中的当前内容。

### 文件输入流

FileInputStream 常用的构造方法主要有如下两种重载形式。

- FileInputStream(File file)：通过打开一个到实际文件的连接来创建一个 FileInputStream，该文件通过文件系统中的 File 对象 file 指定。
- FileInputStream(String name)：通过打开一个到实际文件的链接来创建一个 FileInputStream，该文件通过文件系统中的路径名 name 指定。

注意：*FileInputStream 类重写了父类 InputStream 中的 read() 方法、skip() 方法、available() 方法和 close() 方法，不支持 mark() 方法和 reset() 方法*。

### 文件输出流

 FileOutputStream 类的构造方法主要有如下 4 种重载形式。

- FileOutputStream(File file)：创建一个文件输出流，参数 file 指定目标文件。
- FileOutputStream(File file,boolean append)：创建一个文件输出流，参数 file 指定目标文件，append 指定是否将数据添加到目标文件的内容末尾，**如果为 true，则在末尾添加；如果为 false，则覆盖原有内容；其默认值为 false**。
- FileOutputStream(String name)：创建一个文件输出流，参数 name 指定目标文件的文件路径信息。
- FileOutputStream(String name,boolean append)：创建一个文件输出流，参数 name 和 append 的含义同上。

对文件输出流有如下四点说明：

- 在 FileOutputStream 类的构造方法中指定目标文件时，目标文件可以不存在。
- 目标文件的名称可以是任意的，例如 D:\\abc、D:\\abc.de 和 D:\\abc.de.fg 等都可以，可以使用记事本等工具打开并浏览这些文件中的内容。
- 目标文件所在目录必须存在，否则会拋出 java.io.FileNotFoundException 异常。
- 目标文件的名称不能是已存在的目录。例如 D 盘下已存在 Java 文件夹，那么就不能使用 Java 作为文件名，即不能使用 D:\\Java，否则抛出 java.io.FileNotFoundException 异常。

#### DataInputStream And DataOutputStream

分别继承自FileInputSteam和FileOutputStream

DataInputStream 从数据流读取字节，并且将它们**转换为合适的基本类型或字符串**。DataOutputStream 将它们转换为字节并输出到流。
```java

DataOutputStream output=new DataOutputStream(new FileOutputStream("temp.dat"));
output.writeInt(10);
output.writeChar('k');
output.writeByte(91);
output.writeUTF("jaja");

```

#### BufferdInputStream And BufferdOutputStream

将缓冲I/O数据置于一个缓冲区内，从而能够快速处理

```java
DataOutputStream output=new DataOutputStream(new BufferdOutputStream(new FileOutputStream("temp.dat")));//不用DataOutputStream包装时读取字节
```

#### ObjectOutputStream And ObjectInputStream

包含DataInputStream和DataOutputStream的所有功能，**还能还可以实现对象的输入输出**。

```java

ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("object.dat"));
output.writeObject(new java.util.Date());

ObjectOutputStream input=new ObjectIntputStream(new FileInputStream("object.dat"));
java.util.Date date=(java.util.Date)input.readObject();//必须使用类型转换
//需要声明异常ClassNotFoundExcepion，它是必检异常，因为恢复类时会加载对象所在的类

```xc






