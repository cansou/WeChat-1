package com.xk.ui.main;

import org.eclipse.swt.widgets.Composite;

import com.xk.bean.User;
import com.xk.ui.items.ContactItem;
import com.xk.uiLib.ICallable;
import com.xk.uiLib.ICallback;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;


public class MyInfoComp extends Composite implements ICallable {

	private ICallback callBack;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MyInfoComp(Composite parent, int style, User user) {
		super(parent, style);
		setBackgroundMode(SWT.INHERIT_FORCE);
		setBackground(SWTResourceManager.getColor(255, 255, 255));
		setBounds(0, 0, 180, 255);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 0, 180, 180);
		if(null != user && null != user.head) {
			composite.setBackgroundImage(user.head);
		} else {
			composite.setBackgroundImage(SWTResourceManager.getImage(ContactItem.class, "/images/head.png"));
		}
		
		
		Label label = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label.setBounds(0, 220, 180, 1);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setForeground(SWTResourceManager.getColor(169, 169, 169));
		label_1.setAlignment(SWT.RIGHT);
		label_1.setBounds(0, 192, 56, 17);
		label_1.setText("备  注");
		
		Label label_2 = new Label(this, SWT.NONE);
		label_2.setBounds(62, 192, 61, 17);
		label_2.setText(user.RemarkName);
		
		CLabel lblNewLabel = new CLabel(this, SWT.CENTER);
		lblNewLabel.setCursor(SWTResourceManager.getCursor(SWT.CURSOR_HAND));
		lblNewLabel.setForeground(SWTResourceManager.getColor(50, 205, 50));
		lblNewLabel.setFont(SWTResourceManager.getFont("幼圆", 11, SWT.NORMAL));
		lblNewLabel.setBounds(0, 221, 180, 34);
		lblNewLabel.setText("发消息");
		lblNewLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent arg0) {
				if(null != callBack) {
					callBack.callback(1);
				}
			}
			
		});
	}
	
	public void killed() {
		if(null != callBack) {
			callBack.callback(0);
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	@Override
	public void setCallBack(ICallback callBack) {
		this.callBack = callBack;
	}
}
