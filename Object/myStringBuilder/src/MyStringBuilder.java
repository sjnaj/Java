/*
 * @Author: fengsc
 * @Date: 2022-02-23 14:19:17
 * @LastEditTime: 2022-02-23 20:03:54
 */
public class MyStringBuilder {
       private char[] str;
       private int length;

       public MyStringBuilder() {
              this("");// 只有构造函数中能这样调用
       }

       public MyStringBuilder(char[] str) {
              this(new String(str));
       }

       public MyStringBuilder(int capacity) {
              if (capacity > 0)
                     str = new char[capacity];
       }

       public MyStringBuilder(String str) {
              this.length = str.length();
              this.str = new char[str.length() + 16];
              System.arraycopy(str.toCharArray(), 0, this.str, 0, str.length());
       }

       public int capacity() {
              return str.length;
       }

       public int length() {
              return length;
       }

       private void expand(int capacity) {
              if (capacity > str.length) {
                     char[] temp = new char[capacity];
                     System.arraycopy(str, 0, temp, 0, str.length);
                     str = temp;
              }
       }

       public MyStringBuilder append(String s) {
              if (length + s.length() > str.length) {
                     expand(length + s.length());
              }
              System.arraycopy(s.toCharArray(), 0, str, length, s.length());
              length += s.length();
              return this;
       }

       public MyStringBuilder append(int x) {
              return this.append(x + "");
       }

       public char charAt(int index) {
              if (index < 0 || index >= length) {
                     throw new StringIndexOutOfBoundsException("index " + index +
                                   ",length " + length);
              }
              return str[index];
       }

       public MyStringBuilder toUpperCase() {
              String res = new String(str).toUpperCase(); // *没有修改自身
              return new MyStringBuilder(res);
       }

       public MyStringBuilder toLowerCase() {
              String res = new String(str).toLowerCase(); // *没有修改自身
              return new MyStringBuilder(res);
       }

       public String toString() {
              return new String(str);
       }

       public MyStringBuilder substring(int begin, int end) {
              if (begin < 0 || begin > end || end > length) {
                     throw new StringIndexOutOfBoundsException(
                                   "start " + begin + ", end " + end + ", length " + length);
              }
              String res = new String(str).substring(begin, end);
              return new MyStringBuilder(res);
       }

       public MyStringBuilder insert(int offset, MyStringBuilder s) {
              if (offset < 0 || offset > length)
                     throw new StringIndexOutOfBoundsException("offset:" + offset + "length:" + length);
              if (s.length() + length > str.length) {
                     expand(s.length() + length);
              }
              System.arraycopy(str, offset, str, offset + s.length(), length - offset);
              System.arraycopy(s.toString(), 0, str, offset, s.length());
              // str = new
              // StringBuilder(newString(str)).insert(offset,s.toString()).toString().toCharArray();
              length += s.length();
              return this;
       }

       public MyStringBuilder reverse() {

              for (int i = 0; i < length / 2; i++) {
                     int j = length - i - 1;
                     byte value = (byte) str[j];
                     str[j] = str[i];
                     str[i] = (char) value;
              }
              // str=new StringBuilder(new String(str)).reverse().toString().toCharArray();
              return this;
       }

}
