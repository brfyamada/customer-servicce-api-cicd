/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package br.com.byamada.customerserviceapi.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class CustomerDTO extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6086301620243607454L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CustomerDTO\",\"namespace\":\"br.com.byamada.customerserviceapi.avro\",\"fields\":[{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Customer name\"},{\"name\":\"document\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Customer document number\"},{\"name\":\"age\",\"type\":\"int\",\"doc\":\"Customer age\"}],\"version\":\"1\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<CustomerDTO> ENCODER =
      new BinaryMessageEncoder<CustomerDTO>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CustomerDTO> DECODER =
      new BinaryMessageDecoder<CustomerDTO>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<CustomerDTO> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<CustomerDTO> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<CustomerDTO>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this CustomerDTO to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a CustomerDTO from a ByteBuffer. */
  public static CustomerDTO fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Customer name */
   private java.lang.String name;
  /** Customer document number */
   private java.lang.String document;
  /** Customer age */
   private int age;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CustomerDTO() {}

  /**
   * All-args constructor.
   * @param name Customer name
   * @param document Customer document number
   * @param age Customer age
   */
  public CustomerDTO(java.lang.String name, java.lang.String document, java.lang.Integer age) {
    this.name = name;
    this.document = document;
    this.age = age;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return document;
    case 2: return age;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.String)value$; break;
    case 1: document = (java.lang.String)value$; break;
    case 2: age = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'name' field.
   * @return Customer name
   */
  public java.lang.String getName() {
    return name;
  }


  /**
   * Gets the value of the 'document' field.
   * @return Customer document number
   */
  public java.lang.String getDocument() {
    return document;
  }


  /**
   * Gets the value of the 'age' field.
   * @return Customer age
   */
  public java.lang.Integer getAge() {
    return age;
  }


  /**
   * Creates a new CustomerDTO RecordBuilder.
   * @return A new CustomerDTO RecordBuilder
   */
  public static br.com.byamada.customerserviceapi.avro.CustomerDTO.Builder newBuilder() {
    return new br.com.byamada.customerserviceapi.avro.CustomerDTO.Builder();
  }

  /**
   * Creates a new CustomerDTO RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CustomerDTO RecordBuilder
   */
  public static br.com.byamada.customerserviceapi.avro.CustomerDTO.Builder newBuilder(br.com.byamada.customerserviceapi.avro.CustomerDTO.Builder other) {
    return new br.com.byamada.customerserviceapi.avro.CustomerDTO.Builder(other);
  }

  /**
   * Creates a new CustomerDTO RecordBuilder by copying an existing CustomerDTO instance.
   * @param other The existing instance to copy.
   * @return A new CustomerDTO RecordBuilder
   */
  public static br.com.byamada.customerserviceapi.avro.CustomerDTO.Builder newBuilder(br.com.byamada.customerserviceapi.avro.CustomerDTO other) {
    return new br.com.byamada.customerserviceapi.avro.CustomerDTO.Builder(other);
  }

  /**
   * RecordBuilder for CustomerDTO instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CustomerDTO>
    implements org.apache.avro.data.RecordBuilder<CustomerDTO> {

    /** Customer name */
    private java.lang.String name;
    /** Customer document number */
    private java.lang.String document;
    /** Customer age */
    private int age;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(br.com.byamada.customerserviceapi.avro.CustomerDTO.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.document)) {
        this.document = data().deepCopy(fields()[1].schema(), other.document);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.age)) {
        this.age = data().deepCopy(fields()[2].schema(), other.age);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing CustomerDTO instance
     * @param other The existing instance to copy.
     */
    private Builder(br.com.byamada.customerserviceapi.avro.CustomerDTO other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.document)) {
        this.document = data().deepCopy(fields()[1].schema(), other.document);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.age)) {
        this.age = data().deepCopy(fields()[2].schema(), other.age);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'name' field.
      * Customer name
      * @return The value.
      */
    public java.lang.String getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * Customer name
      * @param value The value of 'name'.
      * @return This builder.
      */
    public br.com.byamada.customerserviceapi.avro.CustomerDTO.Builder setName(java.lang.String value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * Customer name
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'name' field.
      * Customer name
      * @return This builder.
      */
    public br.com.byamada.customerserviceapi.avro.CustomerDTO.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'document' field.
      * Customer document number
      * @return The value.
      */
    public java.lang.String getDocument() {
      return document;
    }

    /**
      * Sets the value of the 'document' field.
      * Customer document number
      * @param value The value of 'document'.
      * @return This builder.
      */
    public br.com.byamada.customerserviceapi.avro.CustomerDTO.Builder setDocument(java.lang.String value) {
      validate(fields()[1], value);
      this.document = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'document' field has been set.
      * Customer document number
      * @return True if the 'document' field has been set, false otherwise.
      */
    public boolean hasDocument() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'document' field.
      * Customer document number
      * @return This builder.
      */
    public br.com.byamada.customerserviceapi.avro.CustomerDTO.Builder clearDocument() {
      document = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'age' field.
      * Customer age
      * @return The value.
      */
    public java.lang.Integer getAge() {
      return age;
    }

    /**
      * Sets the value of the 'age' field.
      * Customer age
      * @param value The value of 'age'.
      * @return This builder.
      */
    public br.com.byamada.customerserviceapi.avro.CustomerDTO.Builder setAge(int value) {
      validate(fields()[2], value);
      this.age = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'age' field has been set.
      * Customer age
      * @return True if the 'age' field has been set, false otherwise.
      */
    public boolean hasAge() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'age' field.
      * Customer age
      * @return This builder.
      */
    public br.com.byamada.customerserviceapi.avro.CustomerDTO.Builder clearAge() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CustomerDTO build() {
      try {
        CustomerDTO record = new CustomerDTO();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.String) defaultValue(fields()[0]);
        record.document = fieldSetFlags()[1] ? this.document : (java.lang.String) defaultValue(fields()[1]);
        record.age = fieldSetFlags()[2] ? this.age : (java.lang.Integer) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CustomerDTO>
    WRITER$ = (org.apache.avro.io.DatumWriter<CustomerDTO>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CustomerDTO>
    READER$ = (org.apache.avro.io.DatumReader<CustomerDTO>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}