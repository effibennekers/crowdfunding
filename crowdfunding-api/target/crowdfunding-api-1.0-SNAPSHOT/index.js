/**
 * Created by rob_000 on 12/07/14.
 */
var server = require("./server");
var router = require("./router");

server.start(router.route);
