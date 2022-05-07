/*
 Copyright (c) Petr Panteleyev. All rights reserved.
 Licensed under the BSD license. See LICENSE file in the project root for full license information.
 */
package org.panteleyev.freedesktop.entry;

import java.util.Set;

/**
 * Defines file entry keys.
 */
enum Key implements CharSequence {
    TYPE("Type"),
    VERSION("Version"),
    NAME("Name"),
    GENERIC_NAME("GenericName"),
    NO_DISPLAY("NoDisplay"),
    COMMENT("Comment"),
    ICON("Icon"),
    HIDDEN("Hidden"),
    ONLY_SHOW_IN("OnlyShowIn"),
    NOT_SHOW_IN("NotShowIn"),
    D_BUS_ACTIVATABLE("DBusActivatable"),
    TRY_EXEC("TryExec", DesktopEntryType.APPLICATION),
    EXEC("Exec", DesktopEntryType.APPLICATION),
    PATH("Path", DesktopEntryType.APPLICATION),
    TERMINAL("Terminal", DesktopEntryType.APPLICATION),
    ACTIONS("Actions", DesktopEntryType.APPLICATION),
    MIME_TYPE("MimeType", DesktopEntryType.APPLICATION),
    CATEGORIES("Categories", DesktopEntryType.APPLICATION),
    KEYWORDS("Keywords", DesktopEntryType.APPLICATION),
    STARTUP_NOTIFY("StartupNotify", DesktopEntryType.APPLICATION),
    STARTUP_WM_CLASS("StartupWMClass", DesktopEntryType.APPLICATION),
    URL("URL", DesktopEntryType.LINK);

    private final String value;
    private final Set<DesktopEntryType> allowed;

    Key(String value, DesktopEntryType... allowed) {
        this.value = value;
        this.allowed = Set.of(allowed);
    }

    Key(String value) {
        this.value = value;
        this.allowed = DesktopEntryType.ALL;
    }

    Set<DesktopEntryType> getAllowed() {
        return allowed;
    }

    @Override
    public int length() {
        return toString().length();
    }

    @Override
    public char charAt(int index) {
        return toString().charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return toString().subSequence(start, end);
    }

    @Override
    public String toString() {
        return value;
    }
}
