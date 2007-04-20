/*
 * $Id$
 *
 * Copyright (C) 2000-2003 Idega Software. All Rights Reserved.
 *
 * This software is the proprietary information of Idega Software.
 * Use is subject to license terms.
 */
package is.idega.block.modernus.presentation;

import java.net.URLEncoder;

import com.idega.presentation.IWContext;
import com.idega.presentation.text.Text;

/**
 * @author palli
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class Modernus extends Text {
	private String _pageName = null;
	private String _owner = null;
	private String _siteName = null;
	
	public Modernus() {
		super();
	}
	
	public Modernus(String owner, String pageName, String siteName) {
		this();
		this._owner = owner;
		this._pageName = pageName;
		this._siteName = siteName;
	}
	
	public void setPageName(String name) {
		this._pageName = name;	
	}
	
	public void setOwner(String owner) {
		this._owner = owner;
	}
	
	public void setSiteName(String name) {
		this._siteName = name;
	}
	
	public String getOwner() {
		return this._owner;
	}
	
	public String getPageName() {
		return this._pageName;
	}
	
	public String getSiteName() {
		return this._siteName;
	}
	
	public void main(IWContext iwc) throws Exception {
		if (this._pageName == null) {
			this._pageName = getParentPage().getLocalizedTitle(iwc);
		}
				
		this._pageName = URLEncoder.encode(this._pageName);

		if (iwc.isInEditMode()) {
			setText("<b>Modernus</b>");
		}
		else {
			StringBuffer buffer = new StringBuffer();
			buffer.append("\n");
			buffer.append("\n");
			buffer.append("<!-- Virk vefmæling byrjar -->\n");
			buffer.append("<script language=\"javascript\"><!--\n");
			buffer.append("  var javas=0;\n");
			buffer.append("//--></script>\n");
			buffer.append("<script language=\"javascript1.1\"><!--\n");
			buffer.append("  var javas=1;\n");
			buffer.append("//--></script>\n");
			buffer.append("<script language=\"javascript\"><!--\n");
			buffer.append("  eigandi = \"");
			buffer.append(this._owner);
			buffer.append("\"\n");
			buffer.append("  sida = \"");
			buffer.append(this._pageName);
			buffer.append("\"\n");
			buffer.append("  if(javas) {\n");
			buffer.append("    run = \"1\"\n");
			buffer.append("  } else {\n");
			buffer.append("    document.write(\"<img width=1 height=1 src=http://");
			buffer.append(this._siteName);
			buffer.append(".teljari.is/teljari.php?eigandi=\"+eigandi+\"&sida=\"+sida+\"&java=10>\");\n");
			buffer.append("  }\n");
			buffer.append("//--></script>\n");
			buffer.append("<script language=\"javascript1.1\" src=\"http://");
			buffer.append(this._siteName);
			buffer.append(".teljari.is/kodi.js\"></script>\n");
			buffer.append("<noscript>\n");
			buffer.append("<img width=1 height=1 src=\"http://");
			buffer.append(this._siteName);
			buffer.append(".teljari.is/teljari.php?eigandi=");
			buffer.append(this._owner);
			buffer.append("&sida=");
			buffer.append(this._pageName);
			buffer.append("\" border=0>\n");
			buffer.append("</noscript>\n");
			buffer.append("<!-- Virk vefmæling endar  -->");
			
			setText(buffer.toString());
		}
	}	
	
	public Object clone() {
		Modernus obj = null;
		try {
			obj = (Modernus)super.clone();
			obj._pageName = this._pageName;
			obj._owner = this._owner;
			obj._siteName = this._siteName;
		}
		catch(Exception ex) {
			ex.printStackTrace(System.err);
		}

		return obj;
	}
}