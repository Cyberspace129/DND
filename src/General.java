public class General {

    public int ReLU(int num) {
        return (num > 0) ? num : 0;
    }

    class Time{
        int hour;
        int minute;
        int second;
        
        public Time(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        public Time Turn_to_Time(int turn) {
            // 1 turn = 6s
            int total_seconds = turn * 6;
            int resultHour = total_seconds / 3600;
            int resultMinute = (total_seconds % 3600) / 60;
            int resultSecond = total_seconds % 60;

            return new Time(resultHour, resultMinute, resultSecond);
        }

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }
    }
    class Turn {
        int turn;

        public Turn(int turn) {
            this.turn = turn;
        }

        public int Time_to_tern(Time time) {
            // time to turn = 6s -> 1 turn
            int total_seconds = time.hour * 3600 + time.minute * 60 + time.second;
            final int turn = total_seconds / 6;
            return turn;
        }

        public int getTurn() {
            return turn;
        }

        public void setTurn(int turn) {
            this.turn = turn;
        }

        @Override
        public String toString() {
            return "Turn [turn=" + turn + "]";
        }
    }
}
