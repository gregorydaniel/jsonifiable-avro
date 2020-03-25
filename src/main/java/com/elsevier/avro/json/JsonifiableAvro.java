package com.elsevier.avro.json;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.JsonEncoder;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificRecordBase;

public class JsonifiableAvro {

  public static <T extends SpecificRecordBase> T fromJson(String json, Schema schema) {
    try {
      return convertToJson(json, schema);
    } catch (IOException e) {
      throw new RuntimeException("Unable to convert from JSON.", e);
    }
  }

  public static String toJson(SpecificRecordBase obj) {
    try {
      return convertToJson(obj);
    } catch (IOException e) {
      throw new RuntimeException("Unable to convert to JSON.", e);
    }
  }

  private static <T extends SpecificRecordBase> T convertToJson(String json, Schema schema)
      throws IOException {
    InputStream input = new ByteArrayInputStream(json.getBytes());
    DataInputStream din = new DataInputStream(input);

    Decoder decoder = DecoderFactory.get().jsonDecoder(schema, din);

    DatumReader<T> reader = new SpecificDatumReader<>(schema);
    return reader.read(null, decoder);
  }

  private static String convertToJson(SpecificRecordBase obj) throws IOException {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();

    JsonEncoder jsonEncoder = EncoderFactory.get().jsonEncoder(obj.getSchema(), bos);
    GenericDatumWriter<Object> writer = new GenericDatumWriter<>(obj.getSchema());

    writer.write(obj, jsonEncoder);
    jsonEncoder.flush();

    return new String(bos.toByteArray(), StandardCharsets.UTF_8);
  }

}
