/**
 * StockPrice.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soar.ws.stockexchange;

public class StockPrice  implements java.io.Serializable {
    private float current;

    private float min;

    private float max;

    public StockPrice() {
    }

    public StockPrice(
           float current,
           float min,
           float max) {
           this.current = current;
           this.min = min;
           this.max = max;
    }


    /**
     * Gets the current value for this StockPrice.
     * 
     * @return current
     */
    public float getCurrent() {
        return current;
    }


    /**
     * Sets the current value for this StockPrice.
     * 
     * @param current
     */
    public void setCurrent(float current) {
        this.current = current;
    }


    /**
     * Gets the min value for this StockPrice.
     * 
     * @return min
     */
    public float getMin() {
        return min;
    }


    /**
     * Sets the min value for this StockPrice.
     * 
     * @param min
     */
    public void setMin(float min) {
        this.min = min;
    }


    /**
     * Gets the max value for this StockPrice.
     * 
     * @return max
     */
    public float getMax() {
        return max;
    }


    /**
     * Sets the max value for this StockPrice.
     * 
     * @param max
     */
    public void setMax(float max) {
        this.max = max;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof StockPrice)) return false;
        StockPrice other = (StockPrice) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.current == other.getCurrent() &&
            this.min == other.getMin() &&
            this.max == other.getMax();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += new Float(getCurrent()).hashCode();
        _hashCode += new Float(getMin()).hashCode();
        _hashCode += new Float(getMax()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(StockPrice.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://stockexchange.ws.soar", "StockPrice"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("current");
        elemField.setXmlName(new javax.xml.namespace.QName("", "current"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("min");
        elemField.setXmlName(new javax.xml.namespace.QName("", "min"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("max");
        elemField.setXmlName(new javax.xml.namespace.QName("", "max"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
