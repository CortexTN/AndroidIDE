/*
 *   Copyright 2020-2021 Rosemoe
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package io.github.rosemoe.editor.widget;

import android.util.SparseIntArray;
import io.github.rosemoe.editor.util.Objects;

/**
 * This class manages the colors of editor.
 * You can use color ids that are not in pre-defined id pool due to new languages.
 * <p>
 * This is also the default color scheme of editor.
 * Be careful to change this class, because this can cause its
 * subclasses behave differently and some subclasses did not apply
 * their default colors to some color ids. So change to this can cause
 * sub themes to change as well.
 * <p>
 * Typically, you can use this class to set color of editor directly
 * with {@link #setColor(int, int)} in a thread with looper.
 * <p>
 * However, we also accept you to extend this class to customize
 * your own ColorScheme to use different default colors.
 * Subclasses is expected to override {@link #applyDefault()}
 * to define colors, though other methods are not final.
 * After overriding this method, you will have to call super class's
 * applyDefault() and then a series of {@link #setColor(int, int)} calls
 * to apply your colors.
 * <p>
 * Note that new colors can be added in newer version of editor,
 * it is dangerous not to call super.applyDefault(), which can cause
 * newer editor works wrongly.
 * <p>
 * For more pre-defined color schemes, please turn to package io.github.rosemoe.editor.widget.schemes
 * <p>
 * Thanks to liyujiang-gzu (GitHub @liyujiang-gzu) for contribution to color schemes
 *
 * @author Rose
 */
public class EditorColorScheme {
	
    //------------------- -< JavaDoc >- -----------------------
    public static final int JD_UNKNOWN_INLINETAG_CONTENT = 102;
    public static final int JD_UNKNOWN_INLINETAG = 101;
    public static final int JD_UNKNOWN_BLOCKTAG_CONTENT= 100;
    public static final int JD_UNKNOWN_BLOCKTAG = 99;
    public static final int JD_VERSION_BODY = 98;
    public static final int JD_VERSION_TAG = 97;
    public static final int JD_VALUE_REFERENCE = 96;
    public static final int JD_VALUE_TAG = 95;
    public static final int JD_USES_SERVICETYPE = 94;
    public static final int JD_USES_DESCRIPTION = 93;
    public static final int JD_USES_TAG = 92;
    public static final int JD_THROWS_NAME = 91;
    public static final int JD_THROWS_DESCRIPTION = 90;
    public static final int JD_THROWS_TAG = 89;
    public static final int JD_SUMMARY_MESSAGE = 88;
    public static final int JD_SUMMARY_TAG = 87;
    public static final int JD_SINCE_TAG = 86;
    public static final int JD_SINCE_BODY = 85;
    public static final int JD_SERIAL_TAG = 84;
    public static final int JD_SERIALDATA_DESCRIPTION = 83;
    public static final int JD_SERIALDATA_TAG = 82;
    public static final int JD_SEE_REFERENCE = 81;
    public static final int JD_SEE_TAG = 80;
    public static final int JD_RETURN_DESCRIPTION = 79;
    public static final int JD_RETURN_TAG = 78;
    public static final int JD_PROVIDES_SERVICETYPE = 77;
    public static final int JD_PROVIDES_DESCRIPTION = 76;
    public static final int JD_PROVIDES_TAG = 75;
    public static final int JD_PARAM_DESCRIPTION = 74;
    public static final int JD_PARAM_NAME = 73;
    public static final int JD_PARAM_TAG = 72;
    public static final int JD_LITERAL_TEXT = 71;
    public static final int JD_LITERAL_TAG = 70;
    public static final int JD_LINK_REFERENCE = 69;
    public static final int JD_LINK_LABEL = 68;
    public static final int JD_LINK_TAG = 67;
    public static final int JD_INHERITDOC_TAG = 66;
    public static final int JD_INDEX_SEARCH_TERM = 65;
    public static final int JD_INDEX_DESCRIPTION = 64;
    public static final int JD_INDEX_TAG = 63;
    public static final int JD_HIDDEN_TAG = 62;
    public static final int JD_HIDDEN_MESSAGE = 61;
    public static final int JD_DOCROOT_TAG = 60;
    public static final int JD_DEPRECATED_MESSAGE= 59;
    public static final int JD_DEPRECATED_TAG = 58;
    public static final int JD_AUTHOR_NAME = 57;
    public static final int JD_AUTHOR_TAG = 56;
    
    public static final int DIAGNOSTIC_ERROR = 38;
    public static final int DIAGNOSTIC_WARNING = 39;
    public static final int DIAGNOSTIC_HINT = 40;
    public static final int DIAGNOSTIC_INFO = 41;
    
	public static final int LOG_DEBUG = 5; // Text Normal
	public static final int LOG_INFO = 32;
	public static final int LOG_ERROR = 33;
	public static final int LOG_WARNING = 34;
    
    public static final int STDERR = 53;
    public static final int STDOUT = 54;
	
    //-----------------Highlight colors-----------
	
    public static final int XML_TAG = 52;
    public static final int FIELD = 35;
    public static final int STATIC_FIELD = 36;
    public static final int PACKAGE_NAME = 37;
    public static final int ENUM_TYPE = 42;
    public static final int INTERFACE = 43;
    public static final int ENUM = 44;
    public static final int PARAMETER = 45;
    public static final int CONSTRUCTOR = 46;
    public static final int STATIC_INIT = 47;
    public static final int INSTANCE_INIT = 48;
    public static final int TYPE_PARAM = 49;
    public static final int RESOURCE_VARIABLE = 50;
    public static final int EXCEPTION_PARAM = 51;
    public static final int ANNOTATION = 28;
    public static final int METHOD_DECLARATION = 27;
    public static final int METHOD_INVOCATION = 55;
    public static final int TYPE_NAME = 26;
    public static final int LOCAL_VARIABLE = 25;
    public static final int LITERAL = 24;
    public static final int OPERATOR = 23;
    public static final int COMMENT = 22;
    public static final int KEYWORD = 21;

    //-------------View colors---------------------

    public static final int NON_PRINTABLE_CHAR = 31;
    public static final int TEXT_SELECTED = 30;
    public static final int MATCHED_TEXT_BACKGROUND = 29;
    public static final int AUTO_COMP_PANEL_CORNER = 20;
    public static final int AUTO_COMP_PANEL_BG = 19;

    /**
     * No longer supported
     */
    public static final int LINE_BLOCK_LABEL = 18;

    public static final int LINE_NUMBER_PANEL_TEXT = 17;
    public static final int LINE_NUMBER_PANEL = 16;
    public static final int BLOCK_LINE_CURRENT = 15;
    public static final int BLOCK_LINE = 14;
    public static final int SCROLL_BAR_TRACK = 13;
    public static final int SCROLL_BAR_THUMB_PRESSED = 12;
    public static final int SCROLL_BAR_THUMB = 11;
    public static final int UNDERLINE = 10;
    public static final int CURRENT_LINE = 9;
    public static final int SELECTION_HANDLE = 8;
    public static final int SELECTION_INSERT = 7;
    public static final int SELECTED_TEXT_BACKGROUND = 6;
    public static final int TEXT_NORMAL = 5;
    public static final int WHOLE_BACKGROUND = 4;
    public static final int LINE_NUMBER_BACKGROUND = 3;
    public static final int LINE_NUMBER = 2;
    public static final int LINE_DIVIDER = 1;
    
    /**
     * Default comment color
     */
    protected static int COMMENT_DEFAULT = 0xffa8a8a8;
    
    /**
     * Start index of Javadoc related color IDs
     */
    public static final int JD_SCHEME_START = 56;
    
    /**
     * End index of Javadoc related color IDs
     */
    public static final int JD_SCHEME_END = 102;

    /**
     * Min pre-defined color id
     */
    protected static final int START_COLOR_ID = 1;

    /**
     * Max pre-defined color id
     */
    protected static final int END_COLOR_ID = 102;
    /**
     * Real color saver
     */
    protected final SparseIntArray mColors;
    /**
     * Host editor object
     */
    private CodeEditor mEditor;
    
    /**
     * Create a new ColorScheme for the given editor
     *
     * @param editor Host editor
     */
    EditorColorScheme(CodeEditor editor) {
        mEditor = editor;
        mColors = new SparseIntArray();
        applyDefault();
    }

    /**
     * For sub classes
     */
    public EditorColorScheme() {
        mColors = new SparseIntArray();
        applyDefault();
    }

    /**
     * Called by editor
     */
    void attachEditor(CodeEditor editor) {
        if (mEditor != null) {
            throw new IllegalStateException("A editor is already attached to this ColorScheme object");
        }
        mEditor = Objects.requireNonNull(editor);
    }

    /**
     * Apply default colors
     */
    public void applyDefault() {
        for (int i = START_COLOR_ID; i <= END_COLOR_ID; i++) {
            applyDefault(i);
        }
    }

    /**
     * Apply default color for the given type
     *
     * @param type The type
     */
    private void applyDefault(int type) {
        
        // By default, all javadoc syntax will be treated as comments
        if(type >= JD_SCHEME_START && type <= JD_SCHEME_END) {
            setColor(type, COMMENT_DEFAULT); // Comment
        }
        
        int color;
        switch (type) {
            case LINE_DIVIDER:
                color = 0xFFdddddd;
                break;
            case LINE_NUMBER:
                color = 0xFF808080;
                break;
            case LINE_NUMBER_BACKGROUND:
                color = 0xfff0f0f0;
                break;
            case WHOLE_BACKGROUND:
            case LINE_NUMBER_PANEL_TEXT:
            case AUTO_COMP_PANEL_BG:
            case AUTO_COMP_PANEL_CORNER:
            case TEXT_SELECTED:
                color = 0xffffffff;
                break;
            case OPERATOR:
                color = 0xFF0066D6;
                break;
            case STDOUT :
            case STDERR :
            case TEXT_NORMAL:
                color = 0xFF333333;
                break;
            case SELECTION_INSERT:
                color = 0xFF03EBEB;
                break;
            case UNDERLINE:
                color = 0xff000000;
                break;
            case SELECTION_HANDLE:
                color = 0xff03ebff;
                break;
            case ANNOTATION:
                color = 0xFF03A9F4;
                break;
            case CURRENT_LINE:
                color = 0x10000000;
                break;
            case SELECTED_TEXT_BACKGROUND:
                color = 0xFF9E9E9E;
                break;
            case KEYWORD:
                color = 0xFF2196F3;
                break;
            case COMMENT:
                color = COMMENT_DEFAULT;
                break;
            case LITERAL:
                color = 0xFF008080;
                break;
            case SCROLL_BAR_THUMB:
                color = 0xffd8d8d8;
                break;
            case SCROLL_BAR_THUMB_PRESSED:
                color = 0xFF27292A;
                break;
            case BLOCK_LINE:
                color = 0xffdddddd;
                break;
            case LINE_BLOCK_LABEL:
            case SCROLL_BAR_TRACK:
                color = 0;
                break;
            case LINE_NUMBER_PANEL:
                color = 0xdd000000;
                break;
            case BLOCK_LINE_CURRENT:
                color = 0xff999999;
                break;
            case LOCAL_VARIABLE:
            case TYPE_NAME:
            case TYPE_PARAM :
            case PARAMETER :
            case METHOD_DECLARATION:
            case ENUM_TYPE :
            case INTERFACE :
            case CONSTRUCTOR :
            case EXCEPTION_PARAM :
            case METHOD_INVOCATION :
                color = 0xff333333;
                break;
            case MATCHED_TEXT_BACKGROUND:
                color = 0xffffff00;
                break;
            case NON_PRINTABLE_CHAR:
                color = 0xff505050;
                break;
			case LOG_ERROR :
				color = 0xffc50e29;
				break;
			case LOG_WARNING :
				color = 0xffff7043;
				break;
			case LOG_INFO :
				color = 0xff4caf50;
				break;
            case FIELD :
            case STATIC_FIELD :
            case ENUM :
                color = 0xFFF0BE4B;
                break;
            case PACKAGE_NAME :
                color = 0xffF0BE4B;
                break;
            case DIAGNOSTIC_ERROR :
                color = 0xfff44336;
                break;
            case DIAGNOSTIC_WARNING :
                color = 0xffFF9800;
                break;
            case DIAGNOSTIC_INFO :
                color = 0xff4CAF50;
                break;
            case DIAGNOSTIC_HINT :
                color = 0xffffffff;
                break;
            default:
                color = 0xffffffff;
        }
        
        setColor(type, color);
    }
    
    public void setJavadocBlockTagColor(final int color) {
        for (int i=JD_SCHEME_START;i<=JD_SCHEME_END;i++) {
            if(isJavadocBlockTag(i)) {
                setColor(i, color);
            }
        }
    }
    
    public void setJavadocInlineTagColor(final int color) {
        for (int i=JD_SCHEME_START;i<=JD_SCHEME_END;i++) {
            if(isJavadocInlineTag(i)) {
                setColor(i, color);
            }
        }
    }
    
    public boolean isJavadocBlockTag (int type) {
        return type == JD_AUTHOR_TAG
        || type == JD_DEPRECATED_TAG
        || type == JD_PARAM_TAG
        || type == JD_RETURN_TAG
        || type == JD_SERIALDATA_TAG
        || type == JD_SERIAL_TAG
        || type == JD_SINCE_TAG
        || type == JD_THROWS_TAG
        || type == JD_UNKNOWN_BLOCKTAG
        || type == JD_VERSION_TAG
        
        // In AndroidIDE, @hidden is considered as a block tag
        || type == JD_HIDDEN_TAG;
    }
    
    public boolean isJavadocInlineTag (int type) {
        return type == JD_DOCROOT_TAG
        || type == JD_INHERITDOC_TAG
        || type == JD_LINK_TAG
        || type == JD_LITERAL_TAG
        || type == JD_UNKNOWN_INLINETAG
        || type == JD_VALUE_TAG;
    }

    /**
     * Apply a new color for the given type
     *
     * @param type  The type
     * @param color New color
     */
    public void setColor(int type, int color) {
        //Do not change if the old value is the same as new value
        //due to avoid unnecessary invalidate() calls
        int old = getColor(type);
        if (old == color) {
            return;
        }

        mColors.put(type, color);

        //Notify the editor
        if (mEditor != null) {
            mEditor.onColorUpdated(type);
        }
    }

    /**
     * Get color by type
     *
     * @param type The type
     * @return The color for type
     */
    public int getColor(int type) {
        return mColors.get(type);
    }

}
