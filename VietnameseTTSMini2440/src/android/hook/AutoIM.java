package android.hook;

/**
 * lớp dùng để thiết lập cách thức nhập sử dụng kiểu gõ Auto
 * sẽ tự động trả về các phím nhấn tương ứng với cả 3 kiểu gõ
 * 
 * @author LamPT
 *
 */
public class AutoIM implements InputMethod {
	
	/** 
	 * ghi đè từ phương thức của interface InputMethod
	 * hàm chuyển kí tự dấu tương ứng từ kiểu gõ Auto về kiểu gõ VNI
	 * 
	 * @keyChar kí tự nhập vào
	 * @curChar kí tự tại vị trí hiện tại của con trỏ
	 * @curWord từ xác định tại vị trí hiện tại của con trỏ
	 * @return trả về kí tự dấu tương ứng với kiểu VNI từ kí tự vào kiểu Auto
	 */
	@Override
    public char getAccentMark(char keyChar, char curChar, String curWord) {
        char accent = '\0';

        if (Character.isDigit(keyChar)) {
            accent = keyChar;
        } else if (Character.isLetter(keyChar)) {
            switch (keyChar) {
                case 'S':
                case 's': accent = '1'; break;
                case 'F':
                case 'f': accent = '2'; break;
                case 'R':
                case 'r': accent = '3'; break;
                case 'X':
                case 'x': accent = '4'; break;
                case 'J':
                case 'j': accent = '5'; break;
                case 'A':
                case 'a':
                case 'E':
                case 'e':
                case 'O':
                case 'o': accent = '6'; break;
                case 'W':
                case 'w': accent = '7'; break;
                case 'D':
                case 'd': accent = '9'; break;
                case 'Z':
                case 'z': accent = '0'; break;
            }

            // Determine accent for common keys shared among a, e, o, w
            if (accent == '6' || accent == '7') {
                accent = VietKeyInput.getAccentInTelex(curWord, keyChar, accent);
            }
        } else {
            switch (keyChar) {
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
        }

        return accent;
    }
}
