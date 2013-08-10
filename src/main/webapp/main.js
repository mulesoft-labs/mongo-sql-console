(function ($) {
    $(function () {
        var terminal = $("#terminal"),
            history = $("#history"),
            cursor = $("#cursor"),
            writer = $("#writer"),
            textarea = $('#setter'),
            template = '<span class="name">yulia</span> at <span class="computer">air.local</span><span class="directory"> ~\/Projects\/any-console\/ </span>';

        //TODO: hardcoded for now
        var patt = /(select|from|where|update|set)/g;

        initTextarea();
        initNewLine();
        textarea.focus();

        function initTextarea() {
            textarea.keydown(function () {
                writeit(this, event);
                moveIt(this.value.length, event);
            });
            textarea.keyup(function () {
                writeit(this, event);
            });
            textarea.keypress(function () {
                writeit(this, event);
            });
            terminal.click(function () {
                textarea.focus();
            });
        }

        function initNewLine(txt) {
            history.append("<br/>").append(template);
        }

        function addToHistory(command, txt) {
            history.append("<br/>$ ");

            if (txt !== "") {
                history.append(command).append("<br/>").append(JSON.stringify(txt, undefined, 2));
            }
        }

        function nl2br(txt) {
            return txt.replace(/\n/g, "<br />");
        }

        function checkKeywords(command) {
            var keyword = "", modified_command = command;
            var n = command.match(patt) || null;

            if (!n) {
                return command;
            }

            for (var i = 0; i < n.length; i++) {
                keyword = n[i];
                modified_command = modified_command.replace(keyword.toLowerCase(), "<span class='keyword'>" + keyword + "</span>");
            }
            return modified_command;
        }

        function writeit(from, e) {
            e = e || window.event;
            if (e.keyCode === 13) {
                from.value = "";
            } else {
                var tw = from.value;
                writer.html(checkKeywords(tw));
            }
        }

        function moveIt(count, e) {
            e = e || window.event;
            var keycode = e.keyCode || e.which, command = writer.html();

            if (count === 0) {//TODO: handle empty case
                //reset("", "");
                //return 0;
            }
            if (keycode == 13) {
                getData(command);
            } else {
                if (keycode == 37 && parseInt(cursor.style.left) >= (0 - ((count - 1) * 10))) {
                    cursor.style.left = parseInt(cursor.style.left) - 10 + "px";
                } else if (keycode == 39 && (parseInt(cursor.style.left) + 10) <= 0) {
                    cursor.style.left = parseInt(cursor.style.left) + 10 + "px";
                }
            }
        }

        function reset(command, data) {
            addToHistory(command, data);
            initNewLine();
            writer.html("");
        }

        function getData(command) {
            $.ajax({
                type: "POST",
                url: "api/mongo",
                data: command.replace(/<(?:.|\n)*?>/gm, ''),
                contentType: "application/json",
                success: function (data) {
                    reset(command, data);
                },
                error: function (e) {
                    reset(command, e);
                }
            });
        }

    });

})(jQuery);
