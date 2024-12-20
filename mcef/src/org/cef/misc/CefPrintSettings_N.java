package org.cef.misc;

import org.cef.callback.CefNative;

import java.awt.*;
import java.util.Vector;

class CefPrintSettings_N extends CefPrintSettings implements CefNative {
    private long N_CefHandle = 0;

    private final native void N_CefPrintSettings_CTOR();

    private final native boolean N_IsValid();

    private final native boolean N_IsReadOnly();

    private final native CefPrintSettings N_Copy();

    private final native void N_SetOrientation(boolean z);

    private final native boolean N_IsLandscape();

    private final native void N_SetPrinterPrintableArea(Dimension dimension, Rectangle rectangle, boolean z);

    private final native void N_SetDeviceName(String str);

    private final native String N_GetDeviceName();

    private final native void N_SetDPI(int i);

    private final native int N_GetDPI();

    private final native void N_SetPageRanges(Vector<CefPageRange> vector);

    private final native int N_GetPageRangesCount();

    private final native void N_GetPageRanges(Vector<CefPageRange> vector);

    private final native void N_SetSelectionOnly(boolean z);

    private final native boolean N_IsSelectionOnly();

    private final native void N_SetCollate(boolean z);

    private final native boolean N_WillCollate();

    private final native void N_SetColorModel(CefPrintSettings.ColorModel colorModel);

    private final native CefPrintSettings.ColorModel N_GetColorModel();

    private final native void N_SetCopies(int i);

    private final native int N_GetCopies();

    private final native void N_SetDuplexMode(CefPrintSettings.DuplexMode duplexMode);

    private final native CefPrintSettings.DuplexMode N_GetDuplexMode();

    private final native void N_CefPrintSettings_DTOR();

    @Override
    public void setNativeRef(String identifer, long nativeRef) {
        this.N_CefHandle = nativeRef;
    }

    @Override
    public long getNativeRef(String identifer) {
        return this.N_CefHandle;
    }

    CefPrintSettings_N() {
    }

    public static final CefPrintSettings createNative() {
        CefPrintSettings_N result = new CefPrintSettings_N();
        try {
            result.N_CefPrintSettings_CTOR();
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
        }
        if (result.N_CefHandle == 0) {
            return null;
        }
        return result;
    }

    protected void finalize() throws Throwable {
        try {
            N_CefPrintSettings_DTOR();
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
        } finally {
            super.finalize();
        }
    }

    @Override
    public boolean isValid() {
        try {
            return N_IsValid();
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isReadOnly() {
        try {
            return N_IsReadOnly();
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
            return false;
        }
    }

    @Override
    public CefPrintSettings copy() {
        try {
            return N_Copy();
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
            return null;
        }
    }

    @Override
    public void setOrientation(boolean landscape) {
        try {
            N_SetOrientation(landscape);
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
        }
    }

    @Override
    public boolean isLandscape() {
        try {
            return N_IsLandscape();
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
            return false;
        }
    }

    @Override
    public void setPrinterPrintableArea(Dimension physical_size_device_units, Rectangle printable_area_device_units, boolean landscape_needs_flip) {
        try {
            N_SetPrinterPrintableArea(physical_size_device_units, printable_area_device_units, landscape_needs_flip);
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
        }
    }

    @Override
    public void setDeviceName(String name) {
        try {
            N_SetDeviceName(name);
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
        }
    }

    @Override
    public String getDeviceName() {
        try {
            return N_GetDeviceName();
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
            return null;
        }
    }

    @Override
    public void setDPI(int dpi) {
        try {
            N_SetDPI(dpi);
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
        }
    }

    @Override
    public int getDPI() {
        try {
            return N_GetDPI();
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
            return 0;
        }
    }

    @Override
    public void setPageRanges(Vector<CefPageRange> ranges) {
        try {
            N_SetPageRanges(ranges);
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
        }
    }

    @Override
    public int getPageRangesCount() {
        try {
            return N_GetPageRangesCount();
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
            return 0;
        }
    }

    @Override
    public void getPageRanges(Vector<CefPageRange> ranges) {
        try {
            N_GetPageRanges(ranges);
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
        }
    }

    @Override
    public void setSelectionOnly(boolean selection_only) {
        try {
            N_SetSelectionOnly(selection_only);
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
        }
    }

    @Override
    public boolean isSelectionOnly() {
        try {
            return N_IsSelectionOnly();
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
            return false;
        }
    }

    @Override
    public void setCollate(boolean collate) {
        try {
            N_SetCollate(collate);
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
        }
    }

    @Override
    public boolean willCollate() {
        try {
            return N_WillCollate();
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
            return false;
        }
    }

    @Override
    public void setColorModel(CefPrintSettings.ColorModel model) {
        try {
            N_SetColorModel(model);
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
        }
    }

    @Override
    public CefPrintSettings.ColorModel getColorModel() {
        try {
            return N_GetColorModel();
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
            return null;
        }
    }

    @Override
    public void setCopies(int copies) {
        try {
            N_SetCopies(copies);
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
        }
    }

    @Override
    public int getCopies() {
        try {
            return N_GetCopies();
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
            return 0;
        }
    }

    @Override
    public void setDuplexMode(CefPrintSettings.DuplexMode mode) {
        try {
            N_SetDuplexMode(mode);
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
        }
    }

    @Override
    public CefPrintSettings.DuplexMode getDuplexMode() {
        try {
            return N_GetDuplexMode();
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
            return null;
        }
    }
}
