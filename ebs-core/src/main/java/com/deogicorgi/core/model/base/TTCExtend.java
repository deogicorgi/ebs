package com.deogicorgi.core.model.base;

import com.deogicorgi.core.values.TTCStatusValue;

public abstract class TTCExtend {
    protected TTCStatusValue status;

    public TTCStatusValue getStatus() {
        return status;
    }

    public void setStatus(TTCStatusValue status) {
        this.status = status;
    }
}
