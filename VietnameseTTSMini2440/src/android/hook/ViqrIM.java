package android.hook;

/**
 * lớp quy định cách thức nhập liệu cho kiểu gõ VIQR
 * chuyển các key tương ứng từ kiểu gõ VIQR sang kiểu gõ VNI
 * 
 * @author LamPT
 *
 */
public class ViqrIM implements InputMethod { 
	/** 
	 * ghi đè từ phương thức của interface InputMethod
	 * hàm chuyển kí tự dấu tương ứng từ kiểu gõ Viqr về kiểu gõ VNI
	 * 
	 * @keyChar kí tự nhập vào
	 * @curChar kí tự tại vị trí hiện tại của con trỏ
	 * @curWord từ xác định tại vị trí hiện tại của con trỏ
	 * @retur trả về kí tự dấu tương ứng với kiểu VNI từ kí tự vào kiểu VIQR
	 */
    @Override
    public char getAccentMark(char keyChar, char curChar, String curWord) {
        char accent = '\0';
        
        if (!Character.isLetterOrDigit(keyChar)) {
            switch (keyChar)  {
                case '\'': accent = '1'; break;
                case '`':  accent = '2'; break;
                case '?':  accent = '3'; break;
                case '~':  accent = '4'; break;
                case '.':  accent = '5'; break;
                case '^':  accent = '6'; break;
                case '*':
                case '+':  accent = '7'; break;
                case '(':  accent = '8'; break;
                case '-':  accent = '0'; break;
            }
        } else if (keyChar == 'D' || keyChar == 'd') {
            accent = '9';
        }
        
        return accent;
    }
}
