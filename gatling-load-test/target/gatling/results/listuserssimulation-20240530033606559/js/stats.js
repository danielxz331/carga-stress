var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name--1146707516",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "3000",
        "ok": "3000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "63",
        "ok": "63",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "7917",
        "ok": "7917",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "3407",
        "ok": "3407",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1980",
        "ok": "1980",
        "ko": "-"
    },
    "percentiles1": {
        "total": "3079",
        "ok": "3079",
        "ko": "-"
    },
    "percentiles2": {
        "total": "4998",
        "ok": "4998",
        "ko": "-"
    },
    "percentiles3": {
        "total": "6926",
        "ok": "6926",
        "ko": "-"
    },
    "percentiles4": {
        "total": "7476",
        "ok": "7476",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 295,
    "percentage": 9.833333333333332
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 156,
    "percentage": 5.2
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 2549,
    "percentage": 84.96666666666667
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 0,
    "percentage": 0.0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "250",
        "ok": "250",
        "ko": "-"
    }
},
contents: {
"req_list-users-869781510": {
        type: "REQUEST",
        name: "List Users",
path: "List Users",
pathFormatted: "req_list-users-869781510",
stats: {
    "name": "List Users",
    "numberOfRequests": {
        "total": "3000",
        "ok": "3000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "63",
        "ok": "63",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "7917",
        "ok": "7917",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "3407",
        "ok": "3407",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1980",
        "ok": "1980",
        "ko": "-"
    },
    "percentiles1": {
        "total": "3079",
        "ok": "3079",
        "ko": "-"
    },
    "percentiles2": {
        "total": "4998",
        "ok": "4998",
        "ko": "-"
    },
    "percentiles3": {
        "total": "6926",
        "ok": "6926",
        "ko": "-"
    },
    "percentiles4": {
        "total": "7476",
        "ok": "7476",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 295,
    "percentage": 9.833333333333332
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 156,
    "percentage": 5.2
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 2549,
    "percentage": 84.96666666666667
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 0,
    "percentage": 0.0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "250",
        "ok": "250",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
