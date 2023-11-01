#!/bin/bash

# Run codeprober with logging
PERMIT_REMOTE_CONNECTIONS=true java -Dcpr.session_logger_dir=logs -jar $(dirname "$0")/code-prober.jar $*
