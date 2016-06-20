package day21.mediator;

import java.util.Arrays;

public class FontDialogDirector extends DialogDirector{
	private Button ok;
	private Button cancel;
	private ListBox fontList;
	private EntryField fontName;

	@Override
	public void showDialog() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void widgetChanged(Widget widget) {
		if (widget == fontList) {
			fontName.setText(fontList.getSelection());
			
			System.out.println("폰트가 변경 되었습니다. " + fontName.getText());
		} else if (widget == ok) {
			// 폰트 변경을 적용하고, 대화상자를 없앰
			
			System.out.println("폰트 변경을 적용하였습니다.");
		} else if (widget == cancel) {
			// 대화상자를 없앰
			
			System.out.println("폰트 변경을 취소하였습니다.");
		}
		
	}
	
	protected void createWidgets() {
		ok = new Button(this);
		cancel = new Button(this);
		fontList = new ListBox(this);
		fontName = new EntryField(this);
		
		ok.setText("OK");
		cancel.setText("Cancel");
//		fontList.setList();
		
		// 가능한 폰트 이름들로 리스트 상자를 채움
		fontList.setList(Arrays.asList("맑은 고딕", "돋움", "굴림", "Courier"));
		
		// 생성한 위젯들을 대화상자 안에 조합
	}

	public Button getOk() {
		return ok;
	}

	public Button getCancel() {
		return cancel;
	}

	public ListBox getFontList() {
		return fontList;
	}

	public EntryField getFontName() {
		return fontName;
	}
	
	
}
