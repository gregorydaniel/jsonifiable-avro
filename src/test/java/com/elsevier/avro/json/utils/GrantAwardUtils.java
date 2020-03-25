package com.elsevier.avro.json.utils;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

import com.elsevier.research.grant.award.FundingAsset;
import com.elsevier.research.grant.award.FundingContentObject;
import com.elsevier.research.grant.award.FundingEntity;
import com.elsevier.research.grant.award.FundingIdentifier;
import com.elsevier.research.grant.award.FundingRelation;
import com.elsevier.research.grant.award.GrantAwardFundedItem;
import com.elsevier.research.grant.award.VocabularyReference;

public class GrantAwardUtils {

  public static GrantAwardFundedItem getGrantAwardFundedItem() {
    return new GrantAwardFundedItem(
        new FundingContentObject(
            "Modified CHADS2 and CHA2DS2-VASc scores to predict atrial fibrillation in acute ischemic stroke patients",
            "awarded-grant",
            "2000462473",
            "en",
            "Blue Hedgehogs"),
        new FundingAsset(
            "http://vtw.elsevier.com/data/voc/Contributors/Elsevier/GrantWarehouse/funding",
            "Grant Warehouse Snapshot 28-07-2019",
            "2019-04-01T12:00:00Z",
            singletonList(
                new VocabularyReference(
                    "http://data.elsevier.com/vocabulary/SciValFunders",
                    "9.21")),
            asList(
                new FundingEntity(
                    "base:a1",
                    "eaf:Entity",
                    "1",
                    new FundingIdentifier(
                        "http://data.elsevier.com/vocabulary/FundingIdentifierTypes/FundrefTaxonomyId",
                        "http://data.elsevier.com/vocabulary/SciValFunders/100000050"),
                    "National Heart, Lung, and Blood Institute",
                    singletonList(
                        "NHLBI"),
                    "National Heart, Lung, and Blood Institute",
                    "http://schema.graph.elsevier.com/research/Organization",
                    "http://sws.geonames.org/6252001/",
                    singletonList(
                        "http://data.elsevier.com/vocabulary/FundingEntityRoles/GrantSponsor")),
                new FundingEntity(
                    "base:a2",
                    "eaf:Entity",
                    "1",
                    null,
                    null,
                    null,
                    "2T32HL007182-16",
                    "http://schema.graph.elsevier.com/research/GrantAward",
                    null,
                    null
                )),
            singletonList(
                new FundingRelation(
                    "base:a3",
                    "eaf:Relation",
                    "base:a1",
                    "base:a2",
                    "http://schema.graph.elsevier.com/research/funds",
                    "1"))));
  }
}
