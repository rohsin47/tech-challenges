/**
 * 
 */
package com.crypto.app.model;

/**
 * @author rohsi
 *
 */
public enum AssetType {
	
	STOCK("stock"),
	CALL("call"),
	PUT("put");
	
	String type;
	
	AssetType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public static AssetType resolveAsset(String type) {
        for (AssetType v : AssetType.values()) {
            if (v.getType().equals(type)) {
                return v;
            }
        }
        return null;
    }
}
