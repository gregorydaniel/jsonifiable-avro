package com.elsevier.avro.json;

import static org.assertj.core.api.Assertions.assertThat;

import com.elsevier.avro.json.utils.GrantAwardUtils;
import com.elsevier.research.grant.award.GrantAwardFundedItem;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonifiableTest {

  @Test
  void testRoundRobin() throws Exception {
    GrantAwardFundedItem grantAwardFundedItem = GrantAwardUtils.getGrantAwardFundedItem();
    String actualJson = JsonifiableAvro.toJson(grantAwardFundedItem);

    String expectedJsonString = readFileToString("/grant-award.json");

    // check JSON is as expected
    JSONAssert.assertEquals(expectedJsonString, actualJson, true);

    // check conversion back from JSON to object is equal to the initial object
    GrantAwardFundedItem actualGrantAward = JsonifiableAvro
        .fromJson(actualJson, GrantAwardFundedItem.getClassSchema());

    assertThat(actualGrantAward).isEqualTo(grantAwardFundedItem);
  }

  @SuppressWarnings("SameParameterValue")
  private String readFileToString(String resourcePath) throws IOException {
    return IOUtils.toString(JsonifiableAvro.class.getResourceAsStream(resourcePath),
        StandardCharsets.UTF_8);
  }
}